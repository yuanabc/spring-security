package com.ybinsure.auth.interfaces;

import com.ybinsure.auth.enums.CodeTypeEnum;

import java.util.Optional;

public interface MaxCodeOperator {

    Optional<Long> queryMaxCode(String channelCode, CodeTypeEnum codeTypeEnum, long min);
}
