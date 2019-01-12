package com.ybinsure.auth.service.wrap;

import com.ybinsure.auth.model.data.ChannelDO;
import com.ybinsure.auth.model.link.ChannelLinkBalance;
import com.ybinsure.auth.model.transfer.page.PageParam;
import com.ybinsure.auth.model.transfer.page.PageResult;
import com.ybinsure.auth.model.transfer.param.ChannelQueryPageParamDTO;

import java.util.List;
import java.util.Optional;

public interface ChannelWrapService {

    boolean delete(String id);

    boolean disable(String id, boolean isClearToken);

    boolean update(ChannelDO param);

    /**
     * 检查渠道是否是收费渠道
     * @param channelCode 渠道编码
     * @return 检查结果
     */
    boolean isBill(String channelCode);

    /**
     * 添加渠道，渠道总部，渠道管理员
     * @param param 数据
     * @return 渠道id
     */
    Optional<String> insert(ChannelDO param);

    /**
     * 根据登陆用户的机构权限获取可查询的机构渠道范围
     */
    Optional<List<ChannelDO>> queryAllOfEffective();

    /**
     * 分页查询渠道以及关联的渠道金额
     */
    Optional<PageResult<List<ChannelLinkBalance>>> queryWithPage(PageParam<ChannelQueryPageParamDTO> pageParam);

    /**
     * 查询渠道，渠道总部，渠道管理员，渠道权限
     * @param id 渠道id
     * @return 查询数据
     */
    Optional<ChannelDO> queryChannelLinkAdminAndLinkHeadCompanyAndLinkPermissionById(String id);

    /**
     * 查询渠道的工号使用权限
     * @return 工号使用权限
     */
    Optional<List<String>> queryJobNumberPermission(String channelCode);

}
