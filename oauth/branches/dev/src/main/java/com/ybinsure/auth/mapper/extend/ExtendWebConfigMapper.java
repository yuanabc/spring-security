package com.ybinsure.auth.mapper.extend;

import com.ybinsure.auth.model.data.WebConfigDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExtendWebConfigMapper {

    /**
     * 批量添加
     */
    Integer insertList(@Param("param")List<WebConfigDO> param);
}
