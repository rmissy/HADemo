package com.rmissy.haserver.security.config;

import com.rmissy.entity.User;
import com.rmissy.haserver.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * @projectName: HADemo
 * @description:
 * @author: rhythm
 * @createTime: 2020-04-09 13:48
 **/
@Component
@Slf4j
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserService userService;


    @Override
    public CustomUserDetail loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);
        if (user == null) {throw new UsernameNotFoundException("用户名为" + username + "的用户不存在");}
        //return new CustomUserDetail(user);
        //new ArrayList<String>().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList())  todo 获取权限菜单url
        return new CustomUserDetail(user,new ArrayList<String>().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()),true,true,true,true);
    }
}