package com.rmissy.haserver.controller;

import com.rmissy.haserver.security.config.CustomUserDetail;
import com.rmissy.response.BaseResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.security.web.WebAttributes.AUTHENTICATION_EXCEPTION;

/**
 * @projectName: HADemo
 * @description:
 * @author: rhythm
 * @createTime: 2020-04-11 15:47
 **/
@Controller
@RequestMapping("/loginHandler")
public class LoginController extends BaseController {

    @RequestMapping (value = "/success", name = "登录成功")
    @ResponseBody
    public BaseResponse success( CustomUserDetail detail) {
        return successWithData(detail);
    }

    @RequestMapping(path = "/fail", name = "登录失败")
    @ResponseBody
    public BaseResponse fail(@RequestAttribute(name = AUTHENTICATION_EXCEPTION) AuthenticationException e) {
        return defaultFailedMsg(e.getLocalizedMessage());
    }

    @RequestMapping(path = "/logoutSuccess", name = "退出成功")
    @ResponseBody
    public BaseResponse logoutSuccess() {
        return defaultSuccess();
    }
}