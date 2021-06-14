package com.itis.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName ApplicationContextConfig
 * @Author LCX
 * @Date 2021 2021-06-13 11:47 a.m.
 * @Version 1.0
 **/
@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced // 负载均衡-使用集群服务时需指定此注解
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
