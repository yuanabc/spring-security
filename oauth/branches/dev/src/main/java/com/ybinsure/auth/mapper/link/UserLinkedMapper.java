package com.ybinsure.auth.mapper.link;

import com.ybinsure.auth.model.link.UserExtend;
import com.ybinsure.auth.model.transfer.param.UserLinkedQueryWithPageParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserLinkedMapper {

    List<String> queryUserIdWithPage(@Param("param") UserLinkedQueryWithPageParam param);

    List<UserExtend> queryUserById(@Param("ids") List<String> ids, @Param("orderCase") String orderCase);

    List<String> querySalesIdWithPage(@Param("param") UserLinkedQueryWithPageParam param);

    List<String> queryChannelSalesIdWithPage(@Param("param") UserLinkedQueryWithPageParam param);

    List<UserExtend> querySalesById(@Param("ids") List<String> param, @Param("orderCase") String orderCase);

    List<UserExtend> queryVirtualSales(@Param("channelCode") String channelCode, @Param("salesChannelCode") String salesChannelCode);

    Integer countUserCompanyByNonStatus(@Param("id")String id, @Param("nonCompanyStatus") Byte nonCompanyStatus, @Param("nonCompanyDeleted") Byte nonCompanyDeleted);

}
