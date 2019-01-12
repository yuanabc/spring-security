package com.ybinsure.auth.service.data;

import com.ybinsure.auth.model.data.PolicyAreaDO;

import java.util.List;
import java.util.Optional;

public interface PolicyAreaService {

    Optional<List<PolicyAreaDO>> queryAll();
}
