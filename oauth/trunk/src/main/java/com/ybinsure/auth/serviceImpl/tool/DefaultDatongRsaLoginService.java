package com.ybinsure.auth.serviceImpl.tool;

import com.ybinsure.auth.constant.CompanyLinkTypeCode;
import com.ybinsure.auth.constant.StatusCode;
import com.ybinsure.auth.model.data.CompanyDO;
import com.ybinsure.auth.model.data.UserDO;
import com.ybinsure.auth.model.data.UserRelateCompanyDO;
import com.ybinsure.auth.model.transfer.datong.UserLoginDTO;
import com.ybinsure.auth.service.data.CompanyService;
import com.ybinsure.auth.service.data.UserService;
import com.ybinsure.auth.service.tool.DatongRsaLoginService;
import com.ybinsure.auth.service.wrap.UserWrapService;
import com.ybinsure.auth.util.JsonUtil;
import com.ybinsure.auth.util.RSAUtil;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class DefaultDatongRsaLoginService implements DatongRsaLoginService {

    private final static Logger log = LoggerFactory.getLogger(DefaultDatongRsaLoginService.class);

    // 包含的version字符
    private final static String versionChar = "&version";
    // 分布式锁前缀
    private final static String LOCK_PREFIX = "AuthDaTongRsaLogin:";

    private final UserService userService;
    private final UserWrapService userWrapService;
    private final CompanyService companyService;
    private final RedissonClient redissonClient;

    @Override
    public Optional<String> cryptChar(String sourceMes) {
        if (StringUtils.isBlank(sourceMes)) {
            return Optional.empty();
        }
        if (sourceMes.contains(versionChar)) {
            sourceMes = sourceMes.substring(0, sourceMes.indexOf(versionChar));
        }
        return Optional.of(sourceMes);
    }

    @Override
    public Optional<UserLoginDTO> decrypt(String crypt) {
        if (StringUtils.isBlank(crypt)) {
            log.info("rsa: 登陆密码为空");
            return Optional.empty();
        }
        log.info("rsa原密文---{}", crypt);
        String decryptChar = RSAUtil.decryptByPublicKey(crypt);
        log.info("rsa解密密文---{}", decryptChar);
        return JsonUtil.toPojo(decryptChar, UserLoginDTO.class);
    }

    @Override
    public Optional<UserDO> convertUser(UserLoginDTO param) {
        if (StringUtils.isBlank(param.getChannelNum()) || StringUtils.isBlank(param.getAgentCode())) {
            log.info("rsa: 用户信息agentCode或者channelNum为空---{}", JsonUtil.toJson(param));
            return Optional.empty();
        }
        Optional<UserDO> result = Optional.empty();
        RLock lock = redissonClient.getFairLock(LOCK_PREFIX + param.getAgentCode());
        try {
            lock.tryLock(20, 10, TimeUnit.SECONDS);
            // 检查工号是否存在
            Optional<UserDO> existUserOptional = userService.queryUserLinkCompanyByAgentCodeAndChannelCode(param.getAgentCode(), param.getChannelNum());
            // 工号不存在
            if (!existUserOptional.isPresent()) {
                result = insertOperate(param);
            } else {
                // 禁用状态
                if (StatusCode.DISABLE.equals(existUserOptional.get().getStatus())) {
                    return Optional.empty();
                }
                result = updateOperate(param, existUserOptional.get());
            }
        } catch (InterruptedException e) {
            log.info("rsa处理用户数据失败---{}", e.getMessage());
        } finally {
            lock.unlock();
        }
        return result;
    }

    private Optional<UserDO> insertOperate(UserLoginDTO param) {
        // 检查手机号码是否占用
        Optional<UserDO> phoneIsExistOptional = userService.queryByUserName(param.getPhone(), param.getChannelNum());
        // 占用就删除之前的账号, 删除不成功则返回空信息
        if (phoneIsExistOptional.isPresent() && !userWrapService.delete(phoneIsExistOptional.get().getId())) {
            return Optional.empty();
        }
        return insert(param);
    }

    private Optional<UserDO> insert(UserLoginDTO param) {
        Optional<UserDO> userParamOptional = param.convert();
        if (!userParamOptional.isPresent()) {
            log.info("rsa: 大童登陆用户信息缺少必要参数---{}", JsonUtil.toJson(param));
            return Optional.empty();
        }
        UserDO userParam = userParamOptional.get();
        Optional<CompanyDO> teamCompanyOptional = companyService.query(param.getConvertAgentGroup(), param.getChannelNum());
        if (!teamCompanyOptional.isPresent()) {
            log.info("rsa: 大童登陆用户信息无法匹配交易服机构---{}", JsonUtil.toJson(param));
            return Optional.empty();
        }
        UserRelateCompanyDO teamCompany = teamCompanyOptional.map(CompanyDO::convertUserRelateCompanyDo).get();
        List<UserRelateCompanyDO> companys = new ArrayList<>();
        companys.add(teamCompany);
        userParam.setUserRelateCompanyDOS(companys);
        log.info("rsa: 新增大童登陆用户---{}", JsonUtil.toJson(userParam));
        if (!userWrapService.insertSale(userParam).isPresent()) {
            log.info("rsa: 新增大童登陆用户失败---{}", JsonUtil.toJson(userParam));
            return Optional.empty();
        }
        return Optional.of(userParam);
    }

    private Optional<UserDO> updateOperate(UserLoginDTO param, UserDO existUser) {
        // 工号存在的情况
        // 需要更新信息
        if (param.isUpdated(existUser)) {
            UserDO updateParam = param.getUpdateParam(existUser);
            // 需要更新手机号码
            if (param.isUpdatePhone(existUser)) {
                // 检查手机是否存在
                Optional<UserDO> userNameExistUserOptional = userService.queryByUserName(updateParam.getUserName(), existUser.getChannelCode());
                if (userNameExistUserOptional.isPresent()) {
                    log.info("rsa: 大童登录用户更新手机号已存在---{}", updateParam.getUserName());
                    UserDO clearUserNameParam = new UserDO();
                    clearUserNameParam.setId(userNameExistUserOptional.get().getId());
                    clearUserNameParam.setPhone("");
                    clearUserNameParam.setUserName("");
                    if (!userService.update(clearUserNameParam)) {
                        log.info("rsa: 大童登录用户充值已经存在的手机号码为空失败---{}", updateParam.getUserName());
                        return Optional.empty();
                    }
                }
            }
            // 需要更新团队
            if (param.isUpdateCompany(existUser)) {
                Optional<CompanyDO> teamCompany = companyService.query(param.getConvertAgentGroup(), param.getChannelNum());
                if (!teamCompany.isPresent()) {
                    log.info("rsa: 大童登陆用户信息无法匹配交易服机构---{}", JsonUtil.toJson(param));
                    return Optional.empty();
                }
                List<UserRelateCompanyDO> userRelateCompanyDOS = new ArrayList<>();
                UserRelateCompanyDO team = new UserRelateCompanyDO();
                team.setCompanyId(teamCompany.get().getId());
                team.setCompanyLevel(teamCompany.get().getLevel());
                team.setLinkType(CompanyLinkTypeCode.BELONG);
                userRelateCompanyDOS.add(team);
                updateParam.setUserRelateCompanyDOS(userRelateCompanyDOS);
            }
            log.info("rsa: 更新大童登录用户---{}", JsonUtil.toJson(updateParam).orElse(""));
            if (!userWrapService.updateUserLinkCompanyAndLinkRole(updateParam)) {
                log.info("rsa: 更大童登录用户失败");
                return Optional.empty();
            }
        }
        UserDO result = new UserDO();
        result.setId(existUser.getId());
        result.setUserName(param.getPhone());
        result.setChannelCode(param.getChannelNum());
        return Optional.of(result);
    }

}
