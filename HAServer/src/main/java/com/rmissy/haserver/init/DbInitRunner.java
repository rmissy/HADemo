package com.rmissy.haserver.init;

import org.springframework.beans.BeansException;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @projectName: HADemo
 * @description: 初始化数据
 * @author: rhythm
 * @createTime: 2020-04-09 16:52
 **/
@Component
public class DbInitRunner implements ApplicationRunner, ApplicationContextAware {
    private ApplicationContext applicationContext;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Arrays.stream(applicationContext.getBeanNamesForType(InitDatabase.class))
                .forEach(bean -> applicationContext.getBean(bean, InitDatabase.class).execute());

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}