package com.ybinsure.auth.serviceImpl.data;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ybinsure.auth.constant.StatusCode;
import com.ybinsure.auth.constant.UserTypeCode;
import com.ybinsure.auth.enums.CodeTypeEnum;
import com.ybinsure.auth.exception.FailResultException;
import com.ybinsure.auth.mapper.data.UserDOMapper;
import com.ybinsure.auth.mapper.extend.ExtendUserMapper;
import com.ybinsure.auth.model.data.UserDO;
import com.ybinsure.auth.model.data.UserDOExample;
import com.ybinsure.auth.model.transfer.page.PageParam;
import com.ybinsure.auth.model.transfer.page.PageResult;
import com.ybinsure.auth.service.data.UserService;
import com.ybinsure.auth.service.tool.VerificationCodeService;
import com.ybinsure.auth.util.EncryptionUtil;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static com.ybinsure.auth.model.data.UserDOExample.Criteria;

@Component
@RequiredArgsConstructor
public class DefaultUserService implements UserService {

    private static final String defaultPassword = "88888888";
    private final Logger logger = LoggerFactory.getLogger(DefaultUserService.class);
    private final UserDOMapper userDOMapper;
    private final ExtendUserMapper extendUserMapper;
    private final PasswordEncoder passwordEncoder;
    private final VerificationCodeService verificationCodeService;

    @Override
    public Optional<String> insert(UserDO userDO) {
        if (userDO == null) {
            return Optional.empty();
        }
        if (StringUtils.isNotBlank(userDO.getPassword())) {
            userDO.setPassword(passwordEncoder.encode(userDO.getPassword()));
        }
        userDO.setCreateTime(System.currentTimeMillis());
        userDO.setUpdateTime(System.currentTimeMillis());
        if (userDOMapper.insertSelective(userDO) > 0) {
            return Optional.of(userDO.getId());
        }
        return Optional.empty();
    }

    @Override
    public boolean update(UserDO param) {
        if (StringUtils.isBlank(param.getId())) {
            return false;
        }
        if (!isExistById(param.getId())) {
            return false;
        }
        param.setPassword(null); // 不更新密码
        param.setDeleted(null);
        param.setUpdateTime(System.currentTimeMillis());
        return userDOMapper.updateByPrimaryKeySelective(param) > 0;
    }

    @Override
    public boolean delete(String id) {
        if (StringUtils.isBlank(id)) {
            return false;
        }
        UserDO clone = new UserDO();
        clone.setId(id);
        clone.setDeleted(StatusCode.ENABLE);
        clone.setUserName("");
        return userDOMapper.updateByPrimaryKeySelective(clone) > 0;
    }

    @Override
    public boolean disable(String id) {
        if (StringUtils.isBlank(id)) {
            return false;
        }
        UserDO clone = new UserDO();
        clone.setId(id);
        clone.setStatus(StatusCode.DISABLE);
        return userDOMapper.updateByPrimaryKeySelective(clone) > 0;
    }

    @Override
    public boolean recovery(String id) {
        if (StringUtils.isBlank(id)) {
            return false;
        }
        UserDO clone = new UserDO();
        clone.setId(id);
        clone.setStatus(StatusCode.ENABLE);
        return userDOMapper.updateByPrimaryKeySelective(clone) > 0;
    }

    @Override
    @Transactional
    public Optional<String> resetPassword(String id, Boolean sendMessage) {
        UserDO userDO = query(id).orElseThrow(() -> new FailResultException("用户不存在"));
        String password = userDO.getPasswordWithPhone().orElse(defaultPassword);
        String encryptPassword = EncryptionUtil.md5(password);
        if (!updatePassword(id, encryptPassword)) {
            throw FailResultException.nonError();
        }

        if (sendMessage && !this.verificationCodeService.sendDefaultPassword(userDO.getPhone(), userDO.getChannelCode(), password).isPresent()) {
            throw FailResultException.nonError();
        }
        return Optional.of(password);
    }

    public boolean updatePassword(String id, String md5Password) {
        if (StringUtils.isBlank(id) || StringUtils.isBlank(md5Password)) {
            return false;
        }
        logger.warn("reset password: id: {}, password: {}", id, md5Password);
        UserDO param = new UserDO();
        param.setId(id);
        param.setPassword(passwordEncoder.encode(md5Password));
        param.setUpdateTime(System.currentTimeMillis());
        return userDOMapper.updateByPrimaryKeySelective(param) > 0;
    }

    @Override
    public Optional<PageResult<List<UserDO>>> queryAgentWithPage(PageParam<UserDO> pageParam) {
        if (queryWithPageRequire(pageParam)) {
            return Optional.empty();
        }
        pageParam.getModel().setUserType(UserTypeCode.SALE);
        return queryWithPage(pageParam);
    }

    @Override
    public Optional<UserDO> query(String id) {
        Optional<UserDO> userDOOptional = queryAll(id);
        return userDOOptional;
    }

    @Override
    public Optional<List<UserDO>> querys(List<String> ids) {
        if (ids == null || ids.isEmpty()) {
            return Optional.empty();
        }
        UserDOExample example = new UserDOExample();
        example.or().andIdIn(ids);
        List<UserDO> result = userDOMapper.selectByExample(example);
        return Optional.ofNullable(result);
    }

    @Override
    public Optional<List<String>> queryLastToken(List<String> ids) {
        if (ids == null || ids.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(extendUserMapper.queryLastToken(ids));
    }

    @Override
    public Optional<UserDO> queryAll(String id) {
        if (StringUtils.isBlank(id)) {
            return Optional.empty();
        }
        UserDOExample example = new UserDOExample();
        example.or().andIdEqualTo(id)
                .andDeletedEqualTo(StatusCode.DISABLE);
        List<UserDO> result = userDOMapper.selectByExample(example);
        if (result == null || result.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(result.get(0));
    }

    @Override
    public Optional<UserDO> queryByEnNo(String enNo, String channelCode) {
        if (StringUtils.isBlank(channelCode) || StringUtils.isBlank(enNo)) {
            return Optional.empty();
        }
        UserDOExample example = new UserDOExample();
        example.or().andChannelCodeEqualTo(channelCode)
                .andEnNoEqualTo(enNo)
                .andDeletedEqualTo(StatusCode.DISABLE);
        List<UserDO> userDOS = userDOMapper.selectByExample(example);
        if (userDOS == null || userDOS.isEmpty()) {
            return Optional.empty();
        }
        return Optional.ofNullable(userDOS.get(0));
    }

    @Override
    public Optional<UserDO> queryByAgentCode(String agentCode, String channelCode) {
        if (StringUtils.isBlank(agentCode) || StringUtils.isBlank(channelCode)) {
            return Optional.empty();
        }
        UserDOExample example = new UserDOExample();
        example.or().andChannelCodeEqualTo(channelCode)
                .andAgentCodeEqualTo(agentCode)
                .andDeletedEqualTo(StatusCode.DISABLE);
        List<UserDO> userDOS = userDOMapper.selectByExample(example);
        if (userDOS == null || userDOS.isEmpty()) {
            return Optional.empty();
        }
        return Optional.ofNullable(userDOS.get(0));
    }

    @Override
    public Optional<List<UserDO>> queryByCodes(List<Long> codes) {
        if (codes == null || codes.isEmpty()) {
            return Optional.empty();
        }
        UserDOExample example = new UserDOExample();
        example.or().andCodeIn(codes).andDeletedEqualTo(StatusCode.DISABLE);
        return Optional.ofNullable(userDOMapper.selectByExample(example));
    }

    @Override
    public Optional<UserDO> queryByUserName(String userName) {
        if (StringUtils.isBlank(userName)) {
            return Optional.empty();
        }
        UserDOExample example = new UserDOExample();
        example.or().andUserNameEqualTo(userName).andUserTypeIn(Arrays.asList(UserTypeCode.ADMIN, UserTypeCode.USER)).andDeletedEqualTo(StatusCode.DISABLE);
        List<UserDO> result = userDOMapper.selectByExample(example);
        if (result == null || result.isEmpty()) {
            return Optional.empty();
        }
        return Optional.ofNullable(result.get(0));
    }

    @Override
    public Optional<UserDO> queryByUserName(String userName, String channelCode) {
        if (StringUtils.isBlank(userName) || StringUtils.isBlank(channelCode)) {
            return Optional.empty();
        }
        UserDOExample example = new UserDOExample();
        example.or().andUserNameEqualTo(userName)
                .andChannelCodeEqualTo(channelCode)
                .andUserTypeEqualTo(UserTypeCode.SALE)
                .andDeletedEqualTo(StatusCode.DISABLE);
        List<UserDO> result = userDOMapper.selectByExample(example);
        if (result == null || result.isEmpty()) {
            return Optional.empty();
        }
        return Optional.ofNullable(result.get(0));
    }

    @Override
    public Optional<UserDO> queryFist(String channelCode) {
        if (StringUtils.isBlank(channelCode)) {
            return Optional.empty();
        }
        return Optional.ofNullable(extendUserMapper.queryFirst(channelCode));
    }

    @Override
    public Optional<UserDO> queryAdmin(String channelCode) {
        if (StringUtils.isBlank(channelCode)) {
            return Optional.empty();
        }
        UserDOExample example = new UserDOExample();
        example.or().andUserTypeEqualTo(UserTypeCode.ADMIN)
                .andChannelCodeEqualTo(channelCode)
                .andDeletedEqualTo(StatusCode.DISABLE);
        List<UserDO> res = userDOMapper.selectByExample(example);
        if (res.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(res.get(0));
    }

    @Override
    public Optional<Long> queryMaxCode(String channelCode, CodeTypeEnum codeTypeEnum, long min) {
        if (StringUtils.isBlank(channelCode)) {
            return Optional.empty();
        }
        String userType = "";
        switch (codeTypeEnum) {
            case ADMIN:
                userType = UserTypeCode.ADMIN;
                break;
            case USER:
                userType = UserTypeCode.USER;
                break;
            case SALES:
                userType = UserTypeCode.SALE;
                break;
        }
        return Optional.ofNullable(extendUserMapper.queryMaxCode(channelCode, userType, min));
    }

    @Override
    public Optional<List<String>> queryLastTokenByNonExpire(String channelCode) {
        if (StringUtils.isBlank(channelCode)) {
            return Optional.empty();
        }
        Date now = new Date();
        return Optional.ofNullable(extendUserMapper.queryLastTokenByTokenNonExpire(channelCode, now));
    }

    private Optional<PageResult<List<UserDO>>> queryWithPage(PageParam<UserDO> pageParam) {
        UserDOExample example = new UserDOExample();
        Criteria criteria = example.createCriteria();
        criteria.andChannelCodeEqualTo(pageParam.getModel().getChannelCode())
                .andDeletedEqualTo(StatusCode.DISABLE);
        if (StringUtils.isNotBlank(pageParam.getModel().getUserType())) {
            criteria.andUserTypeEqualTo(pageParam.getModel().getUserType());
        }
        PageHelper.startPage(pageParam.getPage(), pageParam.getSize());
        List<UserDO> queryResult = userDOMapper.selectByExample(example);
        long count = ((Page)queryResult).getTotal();
        return Optional.of(PageResult.instance(count, queryResult));
    }

    private boolean queryWithPageRequire(PageParam<UserDO> pageParam) {
        return pageParam.blank() ||
                pageParam.getModel() == null ||
                StringUtils.isBlank(pageParam.getModel().getChannelCode());
    }

    @Override
    public boolean isExistById(String id) {
        if (StringUtils.isBlank(id)) {
            return false;
        }
        UserDOExample example = new UserDOExample();
        example.or().andIdEqualTo(id).andDeletedEqualTo(StatusCode.DISABLE);
        return userDOMapper.countByExample(example) > 0;
    }

    @Override
    public boolean isExistByUserName(String userName) {
        if (StringUtils.isBlank(userName)) {
            return false;
        }
        UserDOExample example = new UserDOExample();
        example.or().andUserNameEqualTo(userName).andDeletedEqualTo(StatusCode.DISABLE);
        return userDOMapper.countByExample(example) > 0;
    }

    @Override
    public boolean isExistByUserNameAndChannelCode(String userName, String channelCode) {
        if (StringUtils.isBlank(userName) || StringUtils.isBlank(channelCode)) {
            return false;
        }
        UserDOExample example = new UserDOExample();
        example.or()
                .andUserNameEqualTo(userName)
                .andChannelCodeEqualTo(channelCode)
                .andDeletedEqualTo(StatusCode.DISABLE);
        return userDOMapper.countByExample(example) > 0;
    }

    @Override
    public boolean isExistByUserNameAndAgentCodeAndChannelCode(UserDO param) {
        if (StringUtils.isBlank(param.getChannelCode()) || StringUtils.isBlank(param.getAgentCode()) || StringUtils.isBlank(param.getUserName())) {
            return false;
        }
        UserDOExample example = new UserDOExample();
        example.or().andUserNameEqualTo(param.getUserName())
                .andAgentCodeNotEqualTo(param.getAgentCode())
                .andChannelCodeEqualTo(param.getChannelCode())
                .andDeletedEqualTo(StatusCode.DISABLE);
        return userDOMapper.countByExample(example) > 0;
    }

    @Override
    public boolean isExistByAgentCodeAndChannelCode(String agentCode, String channelCode) {
        if (StringUtils.isBlank(agentCode) || StringUtils.isBlank(channelCode)) {
            return false;
        }
        UserDOExample example = new UserDOExample();
        example.or().andAgentCodeEqualTo(agentCode)
                .andChannelCodeEqualTo(channelCode)
                .andDeletedEqualTo(StatusCode.DISABLE);
        return userDOMapper.countByExample(example) > 0;
    }
}
