package com.ybinsure.auth.serviceImpl.tool;

import com.ybinsure.auth.bean.property.FrontClientProperty;
import com.ybinsure.auth.bean.property.HostProperty;
import com.ybinsure.auth.bean.property.ServiceClientProperty;
import com.ybinsure.auth.constant.RequestApiPath;
import com.ybinsure.auth.service.tool.RestTemplateRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Component
@RequiredArgsConstructor
public class DefaultRestTemplateRequestService implements RestTemplateRequestService {

    private final String tokenUrl = "?client_id=%s&client_secret=%s&grant_type=%s&username=%s&password=%s";

    private final RestTemplate restTemplate;
    private final ServiceClientProperty serviceClientProperty;
    private final FrontClientProperty frontClientProperty;
    private final HostProperty hostProperty;

    @Override
    public ResponseEntity<Object> tokenWithServiceClient(String userName, String password) {
        return token(getServiceClientUri(userName, password));
    }

    @Override
    public ResponseEntity<Object> tokenWithFrontClient(String userName, String password) {
        return token(getFrontClientUri(userName, password));
    }

    private ResponseEntity<Object> token(URI uri) {
        return restTemplate.exchange(
                uri,
                HttpMethod.GET,
                new HttpEntity<>(""),
                Object.class
        );
    }

    /**
     * 设置请求参数
     */
    private URI getServiceClientUri(String userName, String password) {
        String url = hostProperty.getAuth() + RequestApiPath.AUTH_TOKEN;
        String  param = String.format(
                this.tokenUrl,
                serviceClientProperty.getId(),
                serviceClientProperty.getSecret(),
                serviceClientProperty.getType(),
                userName,
                password
        );
        return URI.create(url + param);
    }

    /**
     * 设置请求参数
     */
    private URI getFrontClientUri(String userName, String password) {
        String url = hostProperty.getAuth() + RequestApiPath.AUTH_TOKEN;
        String  param = String.format(
                this.tokenUrl,
                frontClientProperty.getId(),
                frontClientProperty.getSecret(),
                frontClientProperty.getType(),
                userName,
                password
        );
        return URI.create(url + param);
    }
}
