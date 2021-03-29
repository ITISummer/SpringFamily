package com.ITIS.SpringSecurityDemo1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 继承类 WebSecurityConfigurerAdapter 实现自定义方法
 */
//@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //第二种设置用户名密码方式
        //实现加密
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("123");
        //设置登录用户名和密码，在内存中进行认证
        auth.inMemoryAuthentication().withUser("summer").password(password).roles("admin");
    }

    /**
     * 此方法必须添加
     * @return
     */
    @Bean
    PasswordEncoder password() {
        return new BCryptPasswordEncoder();
    }
}
