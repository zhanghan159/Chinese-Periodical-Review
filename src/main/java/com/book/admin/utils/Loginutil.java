package com.book.admin.utils;

import com.book.admin.mapping.UserMapping;
import com.book.admin.model.User;
import com.book.admin.service.UserService;
import com.book.admin.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

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
