package com.ITIS.SpringSecurityDemo1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@MapperScan("com.ITIS.SpringSecurityDemo1.mapper")
//开启方法的角色安全认证
@EnableGlobalMethodSecurity(securedEnabled=true,prePostEnabled = true)
public class Securitydemo1Application {

    public static void main(String[] args) {
        SpringApplication.run(Securitydemo1Application.class, args);
    }

}
