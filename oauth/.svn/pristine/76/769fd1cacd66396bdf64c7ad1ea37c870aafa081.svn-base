package com.ybinsure.auth.service.data;

import com.ybinsure.auth.model.data.UserDO;
import com.ybinsure.auth.model.transfer.page.PageParam;
import com.ybinsure.auth.model.transfer.page.PageResult;
import com.ybinsure.auth.model.transfer.param.SalesQueryPageParamDTO;
import com.ybinsure.auth.model.transfer.param.UserQueryPageParamDTO;
import com.ybinsure.auth.model.transfer.result.UserRoleCountResult;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<String> insert(UserDO userDO);

    boolean update(UserDO userDO);

    boolean delete(String id);

    boolean disable(String id);

    boolean recovery(String id);

    Optional<String> resetPassword(String id, Boolean sendMessage);

    boolean updatePassword(String id, String md5Password);

    /**
     * 不包含用户的隐私信息
     */
    Optional<UserDO> query(String id);

    Optional<List<UserDO>> querys(List<String> ids);

    /**
     * 查询用户的最后登录token
     * @param ids 用户id
     * @return token数据
     */
    Optional<List<String>> queryLastToken(List<String> ids);

    /**
     * 包含用户的所用信息
     */
    Optional<UserDO> queryAll(String id);

    Optional<UserDO> queryByEnNo(String enNo, String channelCode);

    Optional<UserDO> queryByAgentCode(String agentCode, String channelCode);

    Optional<List<UserDO>> queryByCodes(List<Long> codes);

    /**
     * 查询后台账号
     */
    Optional<UserDO> queryByUserName(String userName);

    /**
     * 查询前端账号
     */
    Optional<UserDO> queryByUserName(String userName, String channelCode);

    Optional<UserDO> queryFistByChannelCode(String channelDo);

    Optional<UserDO> getByEnNoAndChannelCodeOrChannelCode(String channelCode, String enNo);

    Optional<UserDO> queryAdmin(String channelCode);

    /**
     * 查询渠道下token为失效的用户id
     * @param channelCode 渠道编码
     * @return 用户id
     */
    Optional<List<String>> queryLastTokenByNonExpire(String channelCode);

    Optional<UserDO> queryUserLinkCompanyAndLinkRoleById(String id);

    Optional<List<UserDO>> queryUserLinkCompanyByIds(List<String> ids);

    Optional<UserDO> queryUserLinkCompanyByAgentCodeAndChannelCode(String agentCode, String channelCode);

    Optional<List<UserDO>> queryUserByCompanyIdsAndUserTypes(List<String> companyIds, List<String> userTypes);

    /**
     * 分页查询人员信息
     * 包含人员信息，机构信息，角色信息
     * @param pageParam 分页查询参数
     * @return 查询结果
     */
    Optional<PageResult<List<UserDO>>> queryUserLinkCompanyAndLinkRoleWithPage(PageParam<UserQueryPageParamDTO> pageParam);

    /**
     * 分页查询业务员信息
     * 包含人员信息，机构信息
     * @param pageParam 分页查询参数
     * @return 查询结果
     */
    Optional<PageResult<List<UserDO>>> querySalesLinkCompanyWithPage(PageParam<SalesQueryPageParamDTO> pageParam);

    Optional<UserDO> queryUserLinkCompanyByUserNameAndChannelCode(String userName, String channelCode);

    /**
     * 根据用户名，渠道编码查询用户，关联机构，关联权限的信息
     * 渠道编码可以为空
     * @param userName 用户名
     * @param channelCode 渠道编码
     * @return 查询数据
     */
    Optional<UserDO> queryUserLinkCompanyAndLinkPermissionByUserNameAndChannelCode(String userName, String channelCode);

    /**
     * 查询机构内用户未失效的token
     * @param companyId 机构id
     * @return 未失效的token
     */
    Optional<List<String>> queryLastNonExpireTokenByCompanyId(String companyId);

    /**
     * 根据分页查询参数查询渠道下每种角色的人员数量
     * @param pageParam 分页查询参数
     * @return 查询结果
     */
    UserRoleCountResult queryUserRoleCountByPageParam(UserQueryPageParamDTO pageParam);

    /**
     * id是否存在
     */
    boolean isExistById(String id);

    /**
     * 全局是否存在用户名(后台)
     */
    boolean isExistByUserName(String userName);

    /**
     * 渠道下是否存在用户名(前端)
     */
    boolean isExistByUserNameAndChannelCode(String userName, String channelCode);

    /**
     * 渠道下是否存在工号
     */
    boolean isExistByAgentCodeAndChannelCode(String agentCode, String channelCode);

    /**
     * 检查机构下是否有用户
     */
    boolean isExistUserByCompanyId(String companyId);

    /**
     * 检查关联机构是否有禁用状态或者删除状态
     * @param id 人员id
     * @return 检查结果
     */
    boolean hasDisableStatusCompany(String id);

}
