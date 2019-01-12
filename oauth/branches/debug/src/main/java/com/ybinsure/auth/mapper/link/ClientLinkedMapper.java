package com.ybinsure.auth.mapper.link;

import com.ybinsure.auth.model.link.ClientExtend;
import org.apache.ibatis.annotations.Param;

public interface ClientLinkedMapper {

    ClientExtend query(@Param("clientId") String clientId);
}
