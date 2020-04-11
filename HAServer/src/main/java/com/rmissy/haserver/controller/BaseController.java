package com.rmissy.haserver.controller;

import com.rmissy.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.management.ManagementFactory;
import java.util.Date;

/**
 * @projectName: HADemo
 * @description:
 * @author: rhythm
 * @createTime: 2020-03-25 16:17
 **/
@Slf4j
public class BaseController {
    @Autowired
    protected HttpServletRequest request;

    @Autowired
    protected HttpServletResponse response;

    protected BaseResponse defaultSuccess() {
        return new BaseResponse(Boolean.TRUE);
    }

    protected BaseResponse defaultFailedMsg(String errorMsg) {
        return new BaseResponse(Boolean.FALSE, errorMsg);
    }

    protected BaseResponse successWithData(Object data) {
        return new BaseResponse(Boolean.TRUE, data);
    }

    public static Date getServerStqrtTime(){
        long time = ManagementFactory.getRuntimeMXBean().getStartTime();
        return new Date(time);
    }

}