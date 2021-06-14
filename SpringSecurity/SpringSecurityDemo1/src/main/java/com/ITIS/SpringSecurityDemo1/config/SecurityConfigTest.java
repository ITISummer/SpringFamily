package com.ITIS.SpringSecurityDemo1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@Configuration
public class SecurityConfigTest extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;
    //注入数据源 - 实现 remember me 功能
    @Autowired
    private DataSource dataSource;

    /**
     * 注入自定义实现 UserDetailsService 的实现类 - MyUserDetailsService
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(password());
    }

    @Bean
    PasswordEncoder password() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 配置对象 - 实现 remember me 功能
     * @return
     */
//    @Bean
//    public PersistentTokenRepository persistentTokenRepository() {
//        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
//        jdbcTokenRepository.setDataSource(dataSource);
//        //自动创建 token 表-已创建的话则记得注释掉
//        //jdbcTokenRepository.setCreateTableOnStartup(true);
//        return jdbcTokenRepository;
//    }


    /**
     * 配置请求相关信息
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*--------------------------设置 退出 功能--------------------------*/
        http.logout().logoutUrl("/logout").logoutSuccessUrl("/test/hello").permitAll();

        /*--------------------------设置 处理异常 功能--------------------------*/
        http.exceptionHandling().accessDeniedPage("/unAuth.html");
        /*-------------------------------配置没有权限访问跳转自定义页面-------------------------------*/
        http.formLogin()   //自定义自己编写的登录页面
                .loginPage("/login.html")  //登录页面设置
                .loginProcessingUrl("/user/login")   //登录访问路径-登录表单提交请求的路径
                .defaultSuccessUrl("/index") //登录成功之后，跳转路径
                .failureUrl("/unAuth.html").permitAll() ;
        /*----------------------设置权限与角色-当前登录用户，设置哪些路径可以被拥有哪些权限的用户访问--------------------------*/
        http.authorizeRequests()
                 //设置哪些路径可以直接访问，不需要认证
                .antMatchers("/","/user/login").permitAll()
                //1 hasAuthority方法，当前登录的用户，只有具有 admins 权限才可以访问设置的路径
                // .antMatchers("/index").hasAuthority("admins")
                //2 hasAnyAuthority方法，用户有其中一个权限都可以访问指定路径
                // .antMatchers("/index").hasAnyAuthority("admins,manager")
                //3 hasRole方法   ROLE_sale
                //4 hasAnyRole方法   ROLE_sale,ROLE_admin，用户有其中一个角色都可以访问指定路径
                //.antMatchers("/index").hasAnyRole("sale,admin")
//                .antMatchers("/index").hasRole("sale") //只有有 sale 角色的用户才可以访问的路径
                .anyRequest().authenticated();

        /*--------------------------设置 remember me 功能--------------------------*/
//        http.rememberMe().tokenRepository(persistentTokenRepository())
//                .tokenValiditySeconds(60)//设置 token 有效时长，单位秒
//                .userDetailsService(userDetailsService);
        /*--------------------------
        设置跨站请求伪造功能(cross-site request forgery)
        跨站请求攻击，简单地说，是攻击者通过一些技术手段欺骗用户的浏览器去访问
        一个自己曾经认证过的网站并运行一些操作
        （如发邮件，发消息，甚至财产操作如转账和购买商品）。
        由于浏览器曾经认证过，所以被访问的网站会认为是真正的用户操作而去运行。
        这利用了web中用户身份验证的一个漏洞：简单的身份验证只能保证请求发自某个用户的测览器，
        却不能保证请求本身是用户自愿发出的。

        从 Spring Security4.0开始，默认情况下会启用CSRF保护，以防止CSRF攻击应用程序，
        Spring Security CSRF会针对 PATCH,POST,PUT和 DELETE方法进行防护。
        --------------------------*/
        // http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
        /*--------------------------关闭跨站请求伪造功能--------------------------*/
        http.csrf().disable();  //关闭csrf防护
    }
}
