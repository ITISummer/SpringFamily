package com.itis.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ClassName EurekaMain7001
 * @Author LCX
 * @Date 2021 2021-06-13 4:39 p.m.
 * @Version 1.0
 **/
@SpringBootApplication
@EnableEurekaServer // 表明这是服务中心
public class EurekaMain7002 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7002.class,args);
    }
}
