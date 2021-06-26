package com.mobile.application.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@Setter
public class MobileConfiguration {
    @Value("${mobile.url}")
    private String mobileUrl;
    @Value("${mobile.connectionTimeout}")
    private Long mobileConnectionTimeout;
}
