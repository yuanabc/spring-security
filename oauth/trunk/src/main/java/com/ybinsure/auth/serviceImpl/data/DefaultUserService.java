package com.ybinsure.auth.serviceImpl.data;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ybinsure.auth.constant.OrderCode;
import com.ybinsure.auth.constant.SaleTypeCode;
import com.ybinsure.auth.constant.StatusCode;
import com.ybinsure.auth.constant.UserTypeCode;
import com.ybinsure.auth.exception.FailResultException;
import com.ybinsure.auth.mapper.auto.UserDOMapper;
import com.ybinsure.auth.mapper.custom.CustomUserMapper;
import com.ybinsure.auth.model.data.*;
import com.ybinsure.auth.model.transfer.page.PageParam;
import com.ybinsure.auth.model.transfer.page.PageResult;
import com.ybinsure.auth.model.transfer.param.BaseUserQueryPageParam;
import com.ybinsure.auth.model.transfer.param.SalesQueryPageParamDTO;
import com.ybinsure.auth.model.transfer.param.UserQueryPageParamDTO;
import com.ybinsure.auth.model.transfer.result.UserRoleCount;
import com.ybinsure.auth.model.transfer.result.UserRoleCountResult;
import com.ybinsure.auth.service.data.ChannelService;
import com.ybinsure.auth.service.data.CompanyService;
import com.ybinsure.auth.service.data.PermissionService;
import com.ybinsure.auth.service.data.UserService;
import com.ybinsure.auth.service.tool.TimeSequenceService;
import com.ybinsure.auth.service.tool.VerificationCodeService;
import com.ybinsure.auth.util.AuthenticationHelper;
import com.ybinsure.auth.util.EncryptionUtil;
import com.ybinsure.auth.util.SqlPatternUtil;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DefaultUserService implements UserService {

    private static final String defaultPassword = "88888888";
    private final Logger logger = LoggerFactory.getLogger(DefaultUserService.class);
    private final UserDOMapper userDOMapper;
    private final CustomUserMapper customUserMapper;
    private final PermissionService permissionService;
    private final PasswordEncoder passwordEncoder;
    private final VerificationCodeService verificationCodeService;
    private final ChannelService channelService;
    private final TimeSequenceService timeSequenceService;
    private final CompanyService companyService;

    @Override
    public Optional<String> insert(UserDO userDO) {
        if (userDO == null) {
            return Optional.empty();
        }
        if (StringUtils.isNotBlank(userDO.getPassword())) {
            userDO.setPassword(passwordEncoder.encode(userDO.getPassword()));
        }
        String sequence = timeSequenceService.getNextSequence(TimeSequenceService.USER_TYPE);
        userDO.setSequence(sequence);
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
        return Optional.of(customUserMapper.queryLastNonExpireToken(ids, new Date()));
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
    public Optional<UserDO> queryFistByChannelCode(String channelCode) {
        if (StringUtils.isBlank(channelCode)) {
            return Optional.empty();
        }
        return Optional.ofNullable(customUserMapper.queryAnyUser(channelCode));
    }

    @Override
    public Optional<UserDO> getByEnNoAndChannelCodeOrChannelCode(String channelCode, String enNo) {
        if (StringUtils.isNotBlank(channelCode) && StringUtils.isNotBlank(enNo)) {
            return queryByEnNo(enNo, channelCode);
        }
        if (StringUtils.isNotBlank(channelCode)) {
            return queryFistByChannelCode(channelCode);
        }
        return Optional.empty();
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
    public Optional<List<String>> queryLastTokenByNonExpire(String channelCode) {
        if (StringUtils.isBlank(channelCode)) {
            return Optional.empty();
        }
        Date now = new Date();
        return Optional.ofNullable(customUserMapper.queryLastNonExpireTokenByChannelCode(channelCode, now));
    }

    @Override
    public Optional<UserDO> queryUserLinkCompanyByUserNameAndChannelCode(String userName, String channelCode) {
        if (StringUtils.isBlank(userName)) {
            return Optional.empty();
        }
        // 查询用户与机构信息
        Optional<UserDO> result = Optional.ofNullable(customUserMapper.queryUserRelateCompanyAndLinkCompanyByUserNameAndChannelCode(userName, channelCode))
                .filter(list -> !list.isEmpty())
                .map(list -> list.get(0));
        // 区分归属机构和管辖机构
        result.ifPresent(UserDO::setBelongCompanyAndManagerCompany);
        return result;
    }

    @Override
    public Optional<UserDO> queryUserLinkCompanyAndLinkRoleById(String id) {
        if (StringUtils.isBlank(id)) {
            return Optional.empty();
        }
        Optional<UserDO> result = Optional.ofNullable(customUserMapper.queryUserLinkCompanyAndLinkRoleByIds(Collections.singletonList(id)))
                .filter(list -> !list.isEmpty())
                .map(list -> list.get(0));
        result.ifPresent(userDO -> {
            userDO.setBelongCompanyAndManagerCompany();
            setChannelType(userDO);
        });
        return result;
    }

    private void setChannelType(UserDO result) {
        String channelType = channelService.queryByChannelCode(result.getChannelCode()).map(ChannelDO::getType).orElse(null);
        result.setChannelType(channelType);
    }

    @Override
    public Optional<List<UserDO>> queryUserLinkCompanyByIds(List<String> ids) {
        if (ids == null || ids.isEmpty()) {
            return Optional.empty();
        }
        List<UserDO> result = customUserMapper.queryUserLinkCompanyByIds(ids);
        result.forEach(UserDO::setBelongCompanyAndManagerCompany);
        return Optional.of(result);
    }

    @Override
    public Optional<UserDO> queryUserLinkCompanyByAgentCodeAndChannelCode(String agentCode, String channelCode) {
        if (StringUtils.isBlank(agentCode) || StringUtils.isBlank(channelCode)) {
            return Optional.empty();
        }
        Optional<UserDO> result = Optional.ofNullable(customUserMapper.queryUserLinkCompanyByAgentCode(agentCode, channelCode))
                .filter(list -> !list.isEmpty())
                .map(list -> list.get(0));
        result.ifPresent(UserDO::setBelongCompanyAndManagerCompany);
        return result;
    }

    @Override
    public Optional<List<UserDO>> queryUserByCompanyIdsAndUserTypes(List<String> companyIds, List<String> userTypes) {
        if (companyIds == null || companyIds.isEmpty() || userTypes == null || userTypes.isEmpty()) {
            return Optional.empty();
        }
        List<UserDO> result = customUserMapper.queryUserByCompanyIdsAndUserTypes(companyIds, userTypes);
        return Optional.ofNullable(result);
    }

    @Override
    public Optional<PageResult<List<UserDO>>> queryUserLinkCompanyAndLinkRoleWithPage(PageParam<UserQueryPageParamDTO> pageParam) {
        setUserPageParam(pageParam);
        setCompanyIdLevel(pageParam.getModel());
        String userId = AuthenticationHelper.localContextHolderParser().getId().orElseThrow(FailResultException::userInfoError);
        PageHelper.startPage(pageParam.getPage(), pageParam.getSize());
        List<String> ids = customUserMapper.queryUserIdsByPageParam(pageParam.getModel(), userId);
        List<UserDO> result;
        if (!ids.isEmpty()) {
            result = customUserMapper.queryUserLinkCompanyAndLinkRoleByIds(ids);
            result.forEach(UserDO::setBelongCompanyAndManagerCompany);
            Comparator<UserDO> comparator = getComparator(pageParam.getModel().getCreateTime());
            result.sort(comparator);
        } else {
            result = new ArrayList<>();
        }
        long total = ((Page)ids).getTotal();
        return Optional.of(PageResult.instance(total, result));
    }

    private void setUserPageParam(PageParam<UserQueryPageParamDTO> pageParam) {
        // 如果前端没有传递机构入参
        if (pageParam.getModel().getCompanyIds() == null || pageParam.getModel().getCompanyIds().isEmpty()) {
            List<String> companyAuth = AuthenticationHelper.localContextHolderParser().getCompanyAuthority();
            pageParam.getModel().setCompanyIds(companyAuth);
        }

        UserQueryPageParamDTO param = pageParam.getModel();
        param.setNickName(SqlPatternUtil.getPattern(param.getNickName()));
        param.setUserName(SqlPatternUtil.getPattern(param.getUserName()));
        if (param.getCreateTime() != null && OrderCode.ASC == param.getCreateTime()) {
            param.setOrderCase("u.create_time asc");
        } else {
            param.setOrderCase("u.create_time desc");
        }
    }

    @Override
    public Optional<PageResult<List<UserDO>>> querySalesLinkCompanyWithPage(PageParam<SalesQueryPageParamDTO> pageParam) {
        if (pageParam.blank()) {
            return Optional.empty();
        }
        setSalesPageParam(pageParam);
        setCompanyIdLevel(pageParam.getModel());
        String userId = AuthenticationHelper.localContextHolderParser().getId().orElseThrow(FailResultException::userInfoError);
        PageHelper.startPage(pageParam.getPage(), pageParam.getSize());
        List<String> userIds = customUserMapper.querySalesIdsByPageParam(pageParam.getModel(), userId);
        List<UserDO> result;
        if (!userIds.isEmpty()) {
            result = customUserMapper.queryUserLinkCompanyByIds(userIds);
            result.forEach(UserDO::setBelongCompanyAndManagerCompany);
            Comparator<UserDO> comparator = getComparator(pageParam.getModel().getCreateTime());
            result.sort(comparator);
        } else {
            result = new ArrayList<>();
        }
        long count = ((Page) userIds).getTotal();
        return Optional.of(PageResult.instance(count, result));
    }

    private void setSalesPageParam(PageParam<SalesQueryPageParamDTO> pageParam) {
        SalesQueryPageParamDTO param = pageParam.getModel();
        // 如果前端没有传递机构入参
        if (pageParam.getModel().getCompanyIds() == null || pageParam.getModel().getCompanyIds().isEmpty()) {
            List<String> companyAuth = AuthenticationHelper.localContextHolderParser().getCompanyAuthority();
            pageParam.getModel().setCompanyIds(companyAuth);
        }
        if (param.getSalesType() == null || param.getSalesType().isEmpty()) {
            param.setSalesType(Arrays.asList(SaleTypeCode.PERSON, SaleTypeCode.CHANNEL));
        }
        if (param.getCreateTime() != null && OrderCode.ASC == param.getCreateTime()) {
            param.setOrderCase("u.create_time asc");
        } else {
            param.setOrderCase("u.create_time desc");
        }
        param.setPhone(SqlPatternUtil.getPattern(param.getPhone()));
        param.setIdName(SqlPatternUtil.getPattern(param.getIdName()));
        param.setAgentCode(SqlPatternUtil.getPattern(param.getAgentCode()));
    }

    private void setCompanyIdLevel(BaseUserQueryPageParam param) {
        List<String> companyIds = Optional.ofNullable(param.getCompanyIds()).orElseThrow(() -> new FailResultException("没有限定机构"));
        List<CompanyDO> companyDOS = companyService.querys(companyIds).orElseThrow(() -> new FailResultException("没有匹配机构参数"));
        Map<Byte, List<String>> groupCompany = companyDOS.stream().collect(Collectors.groupingBy(CompanyDO::getLevel, Collectors.mapping(CompanyDO::getId, Collectors.toList())));
        param.setCompany0Ids(groupCompany.get((byte)0));
        param.setCompany1Ids(groupCompany.get((byte)1));
        param.setCompany2Ids(groupCompany.get((byte)2));
        param.setCompany3Ids(groupCompany.get((byte)3));
        param.setCompany4Ids(groupCompany.get((byte)4));
        param.setCompany5Ids(groupCompany.get((byte)5));
        param.setCompany6Ids(groupCompany.get((byte)6));
    }

    private Comparator<UserDO> getComparator(Long createTime) {
        if (createTime != null && OrderCode.ASC == createTime) {
            return Comparator.comparingLong(UserDO::getCreateTime);
        } else {
            return (a, b) -> Long.compare(b.getCreateTime(), a.getCreateTime());
        }
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

    @Override
    public Optional<List<String>> queryLastNonExpireTokenByCompanyId(String companyId) {
        if (StringUtils.isBlank(companyId)) {
            return Optional.empty();
        }
        return Optional.of(customUserMapper.queryLastNonExpireTokenByCompanyId(companyId, new Date()));
    }

    @Override
    public UserRoleCountResult queryUserRoleCountByPageParam(UserQueryPageParamDTO pageParam) {
        // 如果前端没有传递机构入参
        if (pageParam.getCompanyIds() == null || pageParam.getCompanyIds().isEmpty()) {
            List<String> companyAuth = AuthenticationHelper.localContextHolderParser().getCompanyAuthority();
            pageParam.setCompanyIds(companyAuth);
        }

        String userId = AuthenticationHelper.localContextHolderParser().getId().orElseThrow(FailResultException::userInfoError);
        List<UserRoleCount> userRoleCounts = customUserMapper.queryUserRoleCountByPageParam(pageParam, userId);
        int total = customUserMapper.queryUserRoleTotalByPageParam(pageParam, userId);
        return new UserRoleCountResult(total, userRoleCounts);
    }

    @Override
    public Optional<UserDO> queryUserLinkCompanyAndLinkPermissionByUserNameAndChannelCode(String userName, String channelCode) {
        if (StringUtils.isBlank(userName)) {
            return Optional.empty();
        }
        Optional<UserDO> result = queryUserLinkCompanyByUserNameAndChannelCode(userName, channelCode);
        result.ifPresent(userDO -> {
            List<PermissionDO> permissionDOS = permissionService.queryByUserId(userDO.getId()).orElseGet(ArrayList::new);
            userDO.setPermissionDOS(permissionDOS);
        });
        return result;
    }

    @Override
    public boolean isExistUserByCompanyId(String companyId) {
        if (StringUtils.isBlank(companyId)) {
            return false;
        }
        return customUserMapper.countByCompanyId(companyId) > 0;
    }

    @Override
    public boolean hasDisableStatusCompany(String id) {
        if (StringUtils.isBlank(id)) {
            return false;
        }
        return customUserMapper.countDisableCompanyById(id) == 0;
    }
}
