package com.rmissy.haserver.utils;

import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

public class RequestUtils {
    public static String getRealIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");

        if (!StringUtils.isEmpty(ip)) {
            ip = ip.split(",")[0];
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        return ip;
    }

    public static String getWebVerifyCode(HttpServletRequest request) {
        String verifyCode = request.getParameter("verifyCode");
        return verifyCode;
    }
}

