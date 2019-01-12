package com.ybinsure.auth.serviceImpl.tool;

import com.ybinsure.auth.enums.CodeTypeEnum;
import com.ybinsure.auth.interfaces.MaxCodeOperator;
import com.ybinsure.auth.model.data.ChannelDO;
import com.ybinsure.auth.service.data.ChannelService;
import com.ybinsure.auth.service.tool.OrderCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DefaultOrderCodeService implements OrderCodeService {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMdd");
    private final ChannelService channelService;

    @Override
    public synchronized Optional<Long> maxCode(String channelCode, CodeTypeEnum codeTypeEnum, MaxCodeOperator maxCodeOperator) {
        Optional<Long> minBaseCode = minOrderNo(channelCode, codeTypeEnum);
        if (!minBaseCode.isPresent()) {
            return Optional.empty();
        }
        Optional<Long> dbMaxCode = maxCodeOperator.queryMaxCode(channelCode, codeTypeEnum, minBaseCode.get());
        Long maxCode;
        if (dbMaxCode.isPresent()) {
            if (isMax(dbMaxCode.get())) {
                return Optional.empty();
            }
            maxCode = dbMaxCode.get() + 1;
        } else {
            maxCode = minBaseCode.get() + 1;
        }
        return Optional.of(maxCode);
    }

    private boolean isMax(long maxCode) {
        return maxCode >= maxCode / 100000 * 100000 + 99999;
    }

    private Optional<Long> minOrderNo(String channelCode, CodeTypeEnum codeTypeEnum) {
        Optional<ChannelDO> channelDOOptional = channelService.queryByChannelCode(channelCode);
        if (!channelDOOptional.isPresent()) {
            return Optional.empty();
        }
        long channelOrderNo = channelDOOptional.get().getOrderCode() * 10000000000000L + codeTypeEnum.getValue() * 100000000000L;
        long res = channelOrderNo + getDateNumber() * 100000;
        return Optional.of(res);
    }

    private long getDateNumber() {
        LocalDate localDate = LocalDate.now();
        return Long.valueOf(localDate.format(formatter));
    }
}
