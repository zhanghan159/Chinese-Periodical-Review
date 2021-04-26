package com.book.admin.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName Loginutil
 * @Description TODO
 * @Author zhanghan.a
 * Data 2021/4/22 21:19
 */
public class Loginutil {
    public static String getCookie (HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies.length == 0) return "";
        for (Cookie cookie: cookies) {
            if ("email".equals(cookie.getName())) return cookie.getValue();
        }
        return "";
    }
}
