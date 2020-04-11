package com.rmissy.haserver.security.config;

import lombok.Data;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

import static com.rmissy.haserver.utils.RequestUtils.*;

/**
 * @projectName: HADemo
 * @description:
 * @author: rhythm
 * @createTime: 2020-04-09 15:10
 **/
public class AuthenticationDetail extends WebAuthenticationDetails implements Serializable {
    private static final long serialVersionUID = 976886137820924078L;

    private String userLoginIp;

    private String verifyCode;


    public AuthenticationDetail(HttpServletRequest request) {
        super(request);
        this.userLoginIp = getRealIp(request);
        this.verifyCode = getWebVerifyCode(request);
    }

    public String getUserLoginIp() {
        return userLoginIp;
    }

    public void setUserLoginIp(String userLoginIp) {
        this.userLoginIp = userLoginIp;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }
}