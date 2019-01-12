package com.ybinsure.auth.bean.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 是否开启代理人同步
 */
@Configuration
@ConfigurationProperties("custom.serverClient")
public class ServiceClientProperty {

    private String id;
    private String secret;
    private String type;

    public ServiceClientProperty() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
