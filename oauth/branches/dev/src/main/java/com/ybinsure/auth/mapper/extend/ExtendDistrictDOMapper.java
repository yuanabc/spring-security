package com.ybinsure.auth.mapper.extend;

import com.ybinsure.auth.model.data.DistrictDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExtendDistrictDOMapper {

    DistrictDO queryByCompanyId(@Param("companyId") String companyId);

    List<DistrictDO> queryWithLevel(@Param("param") List<Byte> levels);

}
