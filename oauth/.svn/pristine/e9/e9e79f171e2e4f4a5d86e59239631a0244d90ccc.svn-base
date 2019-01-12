package com.ybinsure.auth.mapper.custom;

import com.ybinsure.auth.model.data.UserDO;
import com.ybinsure.auth.model.transfer.param.SalesQueryPageParamDTO;
import com.ybinsure.auth.model.transfer.param.UserQueryPageParamDTO;
import com.ybinsure.auth.model.transfer.result.UserRoleCount;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface CustomUserMapper {

    /**
     * 查询渠道内某种用户的最大编码
     * @return 编码
     */
    Long queryMaxCode(@Param("channelCode") String channelCode, @Param("userType") String userType, @Param("min") Long min);

    /**
     * 查询渠道内任意用户
     * @param channelCode 渠道编码
     * @return 用户信息
     */
    UserDO queryAnyUser(@Param("channelCode") String channelCode);

    /**
     * 查询指定用户的last_token，如果last_token不为空
     * @param ids 用户id
     * @return last_token数据
     */
    List<String> queryLastNonExpireToken(@Param("ids") List<String> ids, @Param("now")Date now);

    /**
     * 查询渠道内未失效用户的token
     * @param channelCode 渠道编码
     * @param now 当前时间
     * @return 未失效的token
     */
    List<String> queryLastNonExpireTokenByChannelCode(@Param("channelCode") String channelCode, @Param("now")Date now);

    /**
     * 查询机构内用户未失效的token
     * @param companyId 机构id
     * @param now 当前时间
     * @return 未失效的token
     */
    List<String> queryLastNonExpireTokenByCompanyId(@Param("companyId") String companyId, @Param("now") Date now);

    /**
     * 统计机构下未删除的用户数量
     */
    int countByCompanyId(@Param("companyId") String companyId);

    /**
     * 分页查询用户id
     * @param param 查询参数
     * @return 查询结果
     */
    List<String> queryUserIdsByPageParam(@Param("param")UserQueryPageParamDTO param, @Param("ignoreId")String ignoreId);

    /**
     * 分页查询业务员id
     * @param param 查询参数
     * @return 查询结果
     */
    List<String> querySalesIdsByPageParam(@Param("param")SalesQueryPageParamDTO param, @Param("ignoreId")String ignoreId);

    /**
     * 根据分页查询参数查询渠道下每种角色的人员数量
     * @param param 分页查询参数
     * @return 查询结果
     */
    List<UserRoleCount> queryUserRoleCountByPageParam(@Param("param")UserQueryPageParamDTO param, @Param("ignoreId")String ignoreId);

    /**
     * 根据分页查询参数查询渠道下有角色数量的人数总和
     * @param param 分页查询参数
     * @return 查询结果
     */
    int queryUserRoleTotalByPageParam(@Param("param") UserQueryPageParamDTO param, @Param("ignoreId")String ignoreId);

    /**
     * 查询用户存在处于禁用状态的机构数量
     * @param id 用户id
     * @return 处于禁用状态的机构数量
     */
    Integer countDisableCompanyById(@Param("id")String id);

    /**
     * 根据用户名查询用户信息，用户关联机构，机构数据
     * @param userName 用户名
     * @param channelCode 渠道编码
     * @return 查询数据
     */
    List<UserDO> queryUserRelateCompanyAndLinkCompanyByUserNameAndChannelCode(@Param("userName")String userName, @Param("channelCode") String channelCode);

    /**
     * 根据用户id查询用户信息，用户关联机构，机构数据
     * @param userIds 用户id
     * @return 查询数据
     */
    List<UserDO> queryUserLinkCompanyByIds(@Param("ids") List<String> userIds);

    /**
     * 根据用户id查询用户信息，机构信息，角色信息(还有用户关联机构信息)
     * @param userIds 用户id
     * @return 查询数据
     */
    List<UserDO> queryUserLinkCompanyAndLinkRoleByIds(@Param("ids") List<String> userIds);

    /**
     * 根据用户AgentCode查询用户以及关联的机构数据
     * @param agentCode 用户AgentCode
     * @param channelCode 用户渠道编码
     * @return 查询数据
     */
    List<UserDO> queryUserLinkCompanyByAgentCode(@Param("agentCode") String agentCode, @Param("channelCode") String channelCode);

    /**
     * 查询机构下的某种用户
     * @param companyIds 机构id
     * @param userTypes 用户类型
     * @return 用户数据
     */
    List<UserDO> queryUserByCompanyIdsAndUserTypes(@Param("companyIds") List<String> companyIds, @Param("userTypes")List<String> userTypes);

}
