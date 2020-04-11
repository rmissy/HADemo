package com.rmissy.repository;

import com.rmissy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

/**
 * @projectName: HADemo
 * @description:
 * @author: rhythm
 * @createTime: 2020-03-24 11:31
 **/
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
    Optional<User> findByUsername(String username);
}
