package com.rmissy.haserver.config;

import com.rmissy.haserver.security.properties.WebSecurityConfigProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @projectName: HADemo
 * @description: 结合spring-boot-configuration-processor 开启配置参数
 * @author: rhythm
 * @createTime: 2020-04-09 17:25
 **/
@Configuration
@EnableConfigurationProperties({WebSecurityConfigProperties.class})
public class Config {

}