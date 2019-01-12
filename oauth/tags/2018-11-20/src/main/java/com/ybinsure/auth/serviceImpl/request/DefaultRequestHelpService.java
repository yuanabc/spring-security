package com.ybinsure.auth.serviceImpl.request;

import com.ybinsure.auth.service.request.AccessTokenService;
import com.ybinsure.auth.service.request.RequestHelpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DefaultRequestHelpService implements RequestHelpService {

    private final AccessTokenService accessTokenService;

    @Override
    public HttpHeaders getHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", "Bearer " + accessTokenService.getAccessToken());
        return httpHeaders;
    }
}
