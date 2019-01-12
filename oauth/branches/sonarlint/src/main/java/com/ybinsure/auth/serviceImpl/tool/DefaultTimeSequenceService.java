package com.ybinsure.auth.serviceImpl.tool;

import com.ybinsure.auth.constant.CacheKey;
import com.ybinsure.auth.exception.FailResultException;
import com.ybinsure.auth.service.tool.RedisOperateService;
import com.ybinsure.auth.service.tool.TimeSequenceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
@Slf4j
public class DefaultTimeSequenceService implements TimeSequenceService {

    private static String numberFormat = "yyyyMMddHHmmss";
    private static DateFormat numberDateFormat = new SimpleDateFormat(numberFormat);

    private final RedisOperateService redisOperateService;

    @Override
    public String getNextSequence(String type) {
        List<String> result = getSequence(type, 1L);
        return result.size() > 0 ? result.get(0) : null;
    }

    @Override
    public List<String> getStepSequence(String type, Long step) {
        return getSequence(type, step);
    }

    private List<String> getSequence(String type, Long step) {
        String dateKey = formatSequence(new Date()).orElseThrow(() -> new FailResultException("序列化时间失败"));
        String key = type + "-" + dateKey;
        Long sequence = increment(key, step);
        Long dateValue = Long.valueOf(dateKey) * 100000;
        List<String> result = new ArrayList<>();
        for (int i = 0; i < step; i++) {
            result.add(String.valueOf(dateValue + sequence - i));
        }
        result.sort(String::compareTo);
        return result;
    }

    private Long increment(String key, Long step) {
        Long sequence = redisOperateService.increment(CacheKey.timeSequence + key, step, 60);
        log.info("获取序列号---{}", sequence);
        return sequence;
    }

    private Optional<String> formatSequence(Date date) {
        if (date == null) {
            return Optional.empty();
        }
        return Optional.of(numberDateFormat.format(date));
    }
}
