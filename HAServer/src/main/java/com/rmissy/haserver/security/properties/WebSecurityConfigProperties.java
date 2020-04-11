package com.rmissy.haserver.security.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="web.security")
@Data
public class WebSecurityConfigProperties {
    private boolean verifyCode;
}