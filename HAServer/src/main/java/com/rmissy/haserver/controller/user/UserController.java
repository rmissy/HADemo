package com.rmissy.haserver.controller.user;

import com.rmissy.haserver.controller.BaseController;
import com.rmissy.haserver.service.UserService;
import com.rmissy.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @projectName: HADemo
 * @description:
 * @author: rhythm
 * @createTime: 2020-03-25 16:04
 **/
@Controller
@RequestMapping(value = "/user", name = "用户")
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    @RequestMapping (value = "/addUser", name = "创建用户")
    @ResponseBody
    public BaseResponse addUser() {
        System.out.println(getServerStqrtTime());
        return successWithData("");
    }
}