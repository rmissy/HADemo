package com.rmissy.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * @projectName: HADemo
 * @description:
 * @author: rhythm
 * @createTime: 2020-03-25 16:11
 **/
@Slf4j
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseResponse implements Serializable {
    private static final long serialVersionUID = -1915868199055628394L;
    private Boolean success;
    private String msg;
    private Object data;

    public static BaseResponse init(Boolean success, String msg, Object data){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.data = data;
        baseResponse.msg = msg;
        baseResponse.success = success;
        return baseResponse;
    }

    public static BaseResponse failedWithMsg(String msg){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.msg = msg;
        baseResponse.success = Boolean.FALSE;
        return baseResponse;
    }
    public static BaseResponse success(){
        return new BaseResponse(Boolean.TRUE);
    }

    public BaseResponse() {
    }

    public BaseResponse(Boolean success) {
        this.success = success;
    }

    public BaseResponse(Boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public BaseResponse(Boolean success, Object data) {
        this.success = success;
        this.data = data;
    }

    public BaseResponse(Boolean success, String msg, Object data) {
        this.success = success;
        this.msg = msg;
        this.data = data;
    }
}