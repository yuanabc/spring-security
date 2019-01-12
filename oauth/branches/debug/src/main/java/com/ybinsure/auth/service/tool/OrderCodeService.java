package com.ybinsure.auth.service.tool;

import com.ybinsure.auth.enums.CodeTypeEnum;
import com.ybinsure.auth.interfaces.MaxCodeOperator;

import java.util.Optional;

public interface OrderCodeService {

    Optional<Long> maxCode(String channelCode, CodeTypeEnum codeTypeEnum, MaxCodeOperator maxCodeOperator);

}
