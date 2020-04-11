package com.rmissy.haserver.security.config;

import com.rmissy.haserver.security.properties.WebSecurityConfigProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 * @projectName: HADemo
 * @description: 自定义验证
 * @author: rhythm
 * @createTime: 2020-04-09 11:38
 **/
@Slf4j
@Component
public class CustomAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Autowired
    private WebSecurityConfigProperties webSecurityConfigProperties;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        AuthenticationDetail detail = (AuthenticationDetail) authentication.getDetails();

        if(authentication.getCredentials()==null || !authentication.getCredentials().toString().equals(userDetails.getPassword())){
            throw new BadCredentialsException("密码错误！");
        }


    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
        return customUserDetailService.loadUserByUsername(username);
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        CustomUserDetail userDetails = (CustomUserDetail) this.retrieveUser(authentication.getName(),(UsernamePasswordAuthenticationToken) authentication);
        additionalAuthenticationChecks(userDetails, (UsernamePasswordAuthenticationToken) authentication);

        Object principalToReturn = userDetails;
        //将用户信息塞到SecurityContext中，方便获取当前用户信息
        return this.createSuccessAuthentication(principalToReturn, authentication, userDetails);
    }
}