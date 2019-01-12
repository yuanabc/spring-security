package com.ybinsure.auth.serviceImpl.request;

import com.ybinsure.auth.bean.property.HostProperty;
import com.ybinsure.auth.constant.RequestApiPath;
import com.ybinsure.auth.model.request.finance.ChannelBalanceDO;
import com.ybinsure.auth.model.transfer.Result;
import com.ybinsure.auth.service.request.ChannelBalanceRequestService;
import com.ybinsure.auth.service.request.RequestHelpService;
import com.ybinsure.auth.util.JsonUtil;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DefaultChannelBalanceRequestService implements ChannelBalanceRequestService {

    private final Logger logger = LoggerFactory.getLogger(DefaultChannelBalanceRequestService.class);

    private final RestTemplate restTemplate;
    private final HostProperty hostProperty;
    private final RequestHelpService requestHelpService;

    @Override
    public Optional<List<ChannelBalanceDO>> queryByChannelCodes(List<String> channelCodes) {
        if (channelCodes == null || channelCodes.isEmpty()) {
            return Optional.empty();
        }
        String url = hostProperty.getFinance() + RequestApiPath.FINANCE_CHANNEL_BALANCE_QUERY_BY_CHANNEL_CODES;
        HttpEntity<List<String>> httpEntity = new HttpEntity<>(channelCodes, requestHelpService.getHeaders());
        logger.info("查询渠道金额--url: {}", url);
        logger.info("查询渠道金额--request: {}", JsonUtil.toJson(httpEntity).orElse(""));
        ResponseEntity<Result<List<ChannelBalanceDO>>> responseEntity =
                restTemplate.exchange(url, HttpMethod.POST, httpEntity, new ParameterizedTypeReference<Result<List<ChannelBalanceDO>>>() {
                });
        logger.info("查询渠道金额--response: {}", JsonUtil.toJson(responseEntity).orElse(""));
        if (!responseEntity.getStatusCode().equals(HttpStatus.OK) || !responseEntity.hasBody()) {
            return Optional.empty();
        }
        if (responseEntity.getBody().getData() instanceof List) {
            return Optional.ofNullable((List<ChannelBalanceDO>)responseEntity.getBody().getData());
        }
        return Optional.empty();
    }

}
