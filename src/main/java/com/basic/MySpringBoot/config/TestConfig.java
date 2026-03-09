package com.basic.MySpringBoot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {
    @Bean
    public CustomerVO custorVO() {
        return CustomerVO.builder() //CustomerVOBuilder
                .mode("테스트 환경")
                .rate(0.5)
                .build();
    }

}
