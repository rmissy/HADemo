package com.rmissy.entity;

import com.rmissy.utils.DateUtils;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @projectName: HADemo
 * @description: 用户
 * @author: rhythm
 * @createTime: 2020-03-24 10:01
 **/
@Slf4j
@Data
@Entity
@Table(name = "t_user")
public class User extends BaseEntity {

    private String username;
    private String password;

    public User() {
    }
    public User(String username,String password) {
        this.username = username;
        this.password = password;
        this.setCreateTime(DateUtils.dateFormat(System.currentTimeMillis()));
    }

    public User(User user) {
        this.setId(user.getId());
        this.setUsername(user.getUsername());
        this.setPassword(user.getPassword());
    }
}