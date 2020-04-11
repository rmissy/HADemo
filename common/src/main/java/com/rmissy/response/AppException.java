package com.rmissy.response;

import lombok.Data;

/**
 * @projectName: HADemo
 * @description:
 * @author: rhythm
 * @createTime: 2020-04-09 14:50
 **/
@Data
public class AppException extends RuntimeException {
    private Integer code;

    private String msg;

    public AppException() {
    }

    public AppException(Integer code) {
        this.code = code;
    }

    public AppException(String msg) {
        this.msg = msg;
    }

    public AppException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}