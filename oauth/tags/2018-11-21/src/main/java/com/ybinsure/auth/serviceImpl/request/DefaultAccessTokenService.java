package com.ybinsure.auth.serviceImpl.request;

import com.ybinsure.auth.bean.property.HostProperty;
import com.ybinsure.auth.bean.property.ServiceClientProperty;
import com.ybinsure.auth.bean.property.UserProperty;
import com.ybinsure.auth.constant.RequestApiPath;
import com.ybinsure.auth.model.request.auth.TokenResult;
import com.ybinsure.auth.service.request.AccessTokenService;
import com.ybinsure.auth.util.JsonUtil;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DefaultAccessTokenService implements AccessTokenService {

    private String accessToken;
    private static final String tokenUrl = "?client_id=%s&client_secret=%s&grant_type=%s&username=%s&password=%s";
    private static final Logger logger = LoggerFactory.getLogger(DefaultAccessTokenService.class);

    private final RestTemplate restTemplate;
    private final HostProperty hostProperty;
    private final ServiceClientProperty serviceClientProperty;
    private final UserProperty userProperty;

    @Override
    public String getAccessToken() {
        if (StringUtils.isBlank(accessToken)) {
            refreshAccessToken();
        }
        return accessToken;
    }

    @Override
    @Scheduled(cron = "0 0 */10 * * *")
    public void refreshAccessToken() {
        String url = String.format(
                this.hostProperty.getAuth() + RequestApiPath.AUTH_TOKEN + tokenUrl,
                serviceClientProperty.getId(),
                serviceClientProperty.getSecret(),
                serviceClientProperty.getType(),
                userProperty.getUsername(),
                userProperty.getPassword());
        URI uri = URI.create(url);
        ResponseEntity<TokenResult> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, new HttpEntity<>(""), TokenResult.class);
        logger.info("请求accessToken url--{}", url);
        logger.info("请求accessToken response--{}", JsonUtil.toJson(responseEntity).orElse(""));
        this.accessToken = Optional.ofNullable(responseEntity.getBody()).map(TokenResult::getAccessToken).orElse(null);
    }
}
