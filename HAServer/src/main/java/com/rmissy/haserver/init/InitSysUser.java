package com.rmissy.haserver.init;

import com.rmissy.entity.User;
import com.rmissy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @projectName: HADemo
 * @description: 初始化管理员
 * @author: rhythm
 * @createTime: 2020-04-09 17:00
 **/
@Service
@Transactional
public class InitSysUser implements InitDatabase {
    @Autowired
    private UserRepository userRepository;
    @Override
    public void execute() {
        Optional<User> admin = userRepository.findByUsername("admin");
        if(!admin.isPresent()){
            userRepository.save(new User("admin","123456"));
        }
    }
}