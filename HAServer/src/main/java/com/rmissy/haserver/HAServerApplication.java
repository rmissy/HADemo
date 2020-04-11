package com.rmissy.haServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @projectName: HADemo
 * @description:
 * @author: rhythm
 * @createTime: 2020-03-25 16:03
 **/
@SpringBootApplication
@EntityScan(basePackages = {"com.rmissy.entity"})
@EnableJpaRepositories(basePackages = {"com.rmissy.repository"})
public class HAServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(HAServerApplication.class,args);
    }
}