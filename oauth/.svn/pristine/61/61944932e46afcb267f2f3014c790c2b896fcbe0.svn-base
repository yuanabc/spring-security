package com.ybinsure.auth.service.data;

import com.ybinsure.auth.enums.CodeTypeEnum;
import com.ybinsure.auth.interfaces.MaxCodeOperator;
import com.ybinsure.auth.model.data.UserDO;
import com.ybinsure.auth.model.transfer.page.PageParam;
import com.ybinsure.auth.model.transfer.page.PageResult;

import java.util.List;
import java.util.Optional;

public interface UserService extends MaxCodeOperator {

    Optional<String> insert(UserDO userDO);

    boolean update(UserDO userDO);

    boolean delete(String id);

    boolean disable(String id);

    boolean recovery(String id);

    Optional<String> resetPassword(String id, Boolean sendMessage);

    boolean updatePassword(String id, String md5Password);

    Optional<PageResult<List<UserDO>>> queryAgentWithPage(PageParam<UserDO> pageParam);

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

    Optional<UserDO> queryFist(String channelDo);

    Optional<UserDO> queryAdmin(String channelCode);

    Optional<Long> queryMaxCode(String channelCode, CodeTypeEnum codeTypeEnum, long min);

    /**
     * 查询渠道下token为失效的用户id
     * @param channelCode 渠道编码
     * @return 用户id
     */
    Optional<List<String>> queryLastTokenByNonExpire(String channelCode);

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
     * 渠道下是否存在用户名(非入参AgentCode)
     */
    boolean isExistByUserNameAndAgentCodeAndChannelCode(UserDO param);

    /**
     * 渠道下是否存在工号
     */
    boolean isExistByAgentCodeAndChannelCode(String agentCode, String channelCode);

}
