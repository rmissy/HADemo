package com.rmissy.haserver.security.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.ForwardAuthenticationFailureHandler;
import org.springframework.security.web.authentication.ForwardAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.ForwardLogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @projectName: HADemo
 * @description:
 * @author: rhythm
 * @createTime: 2020-03-26 13:55
 **/
@Configuration
@EnableWebSecurity
//@EnableConfigurationProperties(JwtProperties.class)
@Slf4j
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomAuthenticationProvider customAuthenticationProvider;

    @Autowired
    private CustomAuthenticationDetailSource customAuthenticationDetailSource;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .and().csrf().disable();//开启跨域
        http    /*匿名请求：不需要进行登录拦截的url*/
                .authorizeRequests()
                .antMatchers("/getVerifyCode").permitAll()
                .anyRequest().authenticated()//其他的路径都是登录后才可访问
                .and()
                /*登录配置*/
                .formLogin()
                //.loginPage("/login")//登录页，当未登录时会重定向到该页面
                .successHandler(authenticationSuccessHandler())//登录成功处理
                .failureHandler(authenticationFailureHandler())//登录失败处理
                .authenticationDetailsSource(customAuthenticationDetailSource)//自定义验证逻辑，增加验证码信息
                .loginProcessingUrl("/login")//restful登录请求地址
                .usernameParameter("username")//默认的用户名参数
                .passwordParameter("password")//默认的密码参数
                .permitAll()
                .and()
                /*登出配置*/
                .logout()
                .permitAll()
                .logoutSuccessHandler(logoutSuccessHandler());
    }

    private LogoutSuccessHandler logoutSuccessHandler() {
        return new ForwardLogoutSuccessHandler("/loginHandler/logoutSuccess");
    }

    private AuthenticationFailureHandler authenticationFailureHandler() {
        return new ForwardAuthenticationFailureHandler("/loginHandler/fail");
    }

    private AuthenticationSuccessHandler authenticationSuccessHandler() {
        return new ForwardAuthenticationSuccessHandler("/loginHandler/success");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        //将自定义的CustomAuthenticationProvider装配到AuthenticationManagerBuilder
        auth.authenticationProvider(customAuthenticationProvider);
    }
}