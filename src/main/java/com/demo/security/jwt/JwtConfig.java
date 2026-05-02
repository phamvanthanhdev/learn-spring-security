package com.demo.security.jwt;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:/config/jwt-config.properties")
@ConfigurationProperties(prefix = "jwt.token")
public class JwtConfig {
    private String secretKey;
    private Integer expiration;

    public JwtConfig() {
    }

    public JwtConfig(String secretKey, Integer expiration) {
        this.secretKey = secretKey;
        this.expiration = expiration;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public Integer getExpiration() {
        return expiration;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public void setExpiration(Integer expiration) {
        this.expiration = expiration;
    }
}
