package com.ybinsure.auth.bean.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ybinsure.auth.exception.ReturnResultException;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * Created by eric on 17-8-31
 */
@Configuration
public class ProjectConfiguration {

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
        return builder -> {
            builder.failOnUnknownProperties(false);
            builder.serializationInclusion(JsonInclude.Include.NON_NULL);
            builder.indentOutput(false).dateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        };
    }

    /**
     * 未授权的请求处理
     */
    @Bean
    public AuthenticationEntryPoint unauthorizedEntryPoint() {
        return (request, response, authException) -> {
            throw ReturnResultException.loginErrorInstance();
        };
    }

    /**
     * 覆盖RestTemplate对非200状态码的处理
     */
    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new ResponseErrorHandler(){
            @Override
            public boolean hasError(ClientHttpResponse response) throws IOException {
                return true;
            }

            @Override
            public void handleError(ClientHttpResponse response) throws IOException {

            }
        });
        return restTemplate;
    }

}
