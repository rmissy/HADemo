package com.rmissy.haserver.security.config;

import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @projectName: HADemo
 * @description: 获取用户登录 需要的参数
 * @author: rhythm
 * @createTime: 2020-04-09 15:25
 **/
@Component
public class CustomAuthenticationDetailSource implements AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails> {
    @Override
    public WebAuthenticationDetails buildDetails(HttpServletRequest request) {
        return new AuthenticationDetail(request);
    }
}