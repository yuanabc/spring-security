package com.ybinsure.icar.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.ybinsure.icar.user.auth.AuthConst;
import com.ybinsure.icar.user.auth.AuthenticationHelper;
import com.ybinsure.icar.user.constant.ConfigConst;
import com.ybinsure.icar.user.constant.RespInfo;
import com.ybinsure.icar.user.constant.SourceType;
import com.ybinsure.icar.user.mapper.extend.UserExtendMapper;
import com.ybinsure.icar.user.model.AuthInfo;
import com.ybinsure.icar.user.model.ICarResult;
import com.ybinsure.icar.user.model.PageInfo;
import com.ybinsure.icar.user.model.dto.AuthUserDTO;
import com.ybinsure.icar.user.model.dto.OrganizationDTO;
import com.ybinsure.icar.user.model.dto.UserPerformanceDTO;
import com.ybinsure.icar.user.model.param.BonusParam;
import com.ybinsure.icar.user.model.vo.AccountVO;
import com.ybinsure.icar.user.model.vo.BonusVO;
import com.ybinsure.icar.user.model.vo.PerformanceVO;
import com.ybinsure.icar.user.service.func.AccountService;
import com.ybinsure.icar.user.util.DateUtil;
import com.ybinsure.icar.user.util.HttpUtil;
import com.ybinsure.icar.user.util.JsonUtil;
import com.ybinsure.icar.user.util.SourceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 用户服务实现
 *
 * @author HANHT
 * @version 2018/7/7 11:41
 */
@Service
public class AccountServiceImpl implements AccountService {

    private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    private final UserExtendMapper userExtendMapper;

    @Autowired
    public AccountServiceImpl(UserExtendMapper userExtendMapper) {
        this.userExtendMapper = userExtendMapper;
    }

    @Override
    public Optional<AccountVO> queryAccount(AuthInfo param) {
        // 到数据库查询用户信息
        AccountVO accountVO = userExtendMapper.selectAccountInfo(param.getAuth());
        if (accountVO == null) {

            return Optional.empty();
        }

        // 到用户服务查询用户详情
        Optional<AuthUserDTO> authUserOpt = queryUserByToken(param.getToken());
        if (!authUserOpt.isPresent()) {

            return Optional.empty();
        }

        AuthUserDTO authUser = authUserOpt.get();
        accountVO.setUserId(authUser.getId());
        accountVO.setNamed(authUser.getIdName());
        accountVO.setPhone(authUser.getPhone());
        // 赋值机构信息
        accountVO.setBelongCompany(authUser.getBelongCompanys());

        if (!CollectionUtils.isEmpty(accountVO.getBelongCompany())) {
            // 排序
            accountVO.setBelongCompany(accountVO.getBelongCompany().stream().sorted(Comparator.comparing(OrganizationDTO::getLevel).reversed()).collect(Collectors.toList()));
        }

        return Optional.of(accountVO);
    }

    @Override
    public Optional<PerformanceVO> queryPerformance(AuthInfo param) {
        UserPerformanceDTO dto = new UserPerformanceDTO();
        dto.setUserId(param.getAuth());
        dto.setNowTime(System.currentTimeMillis());
        dto.setZeroTime(DateUtil.getZeroTime());
        dto.setMonthTime(DateUtil.getZeroTime(DateUtil.getFirstDayOfMonth()));

        PerformanceVO vo;
        if (SourceType.LIKE_CG == SourceUtil.matchType(AuthenticationHelper.getChannelCode().orElse(""))) {
            vo = userExtendMapper.selectCGPerformanceByCG(dto);
        } else {
            vo = userExtendMapper.selectUserPerformance(dto);
        }

        return Optional.ofNullable(vo);
    }

    @Override
    public Optional<PerformanceVO> queryAccountInfo(AuthInfo param) {

        return Optional.ofNullable(userExtendMapper.searchAccountInfo(param.getAuth()));
    }

    @Override
    public Optional<PageInfo<BonusVO>> listBonus(BonusParam param) {
        PageHelper.startPage(param.getPageNum(), param.getPageSize(), param.assembleSort());

        return Optional.of(PageInfo.instance(userExtendMapper.selectGrantByPage(param)));
    }

    @Override
    public Optional<AuthUserDTO> queryUserByToken(String token) {
        Assert.hasText(token, RespInfo.F515.msg);
        // 到用户服务取用户信息
        String userResult = HttpUtil.doGetWithToken(ConfigConst.AUTH_URL + AuthConst.QUEYR_BY_TOKEN, token);
        Assert.hasText(userResult, RespInfo.F515.msg);

        return handleResult(userResult);
    }

    /**
     * 获取UserAuthDTO
     *
     * @param userResult 请求结果
     * @return UserAuthDTO
     */
    private Optional<AuthUserDTO> handleResult(String userResult) {
        Assert.hasText(userResult, RespInfo.F515.msg);

        ICarResult result = JsonUtil.toPojo(userResult, ICarResult.class).orElseGet(ICarResult::new);
        // 判断接口是否调用成功
        Assert.state(RespInfo.SUCCESS.code == result.getStatus() && result.getData() != null, RespInfo.F515.msg);

        logger.info("用户结果：{}", JsonUtil.toJson(result.getData()).orElse(""));

        return JsonUtil.toPojo(JsonUtil.toJson(result.getData()).orElse(""), AuthUserDTO.class);
    }
}
