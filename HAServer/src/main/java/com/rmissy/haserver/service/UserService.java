package com.rmissy.haserver.service;

import com.rmissy.entity.User;

/**
 * @projectName: HADemo
 * @description:
 * @author: rhythm
 * @createTime: 2020-03-25 16:20
 **/
public interface UserService {
    User findByUsername(String s);
}
