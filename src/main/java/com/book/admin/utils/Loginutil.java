package com.book.admin.utils;

import com.book.admin.mapping.UserMapping;
import com.book.admin.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName Loginutil
 * @Description TODO
 * @Author zhanghan.a
 * Data 2021/4/22 21:19
 */
public class Loginutil {
    @Autowired
    private static UserMapping userMapping;

    public static int userIdentity(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if(cookies==null) {
            return 0;
        }
        for(Cookie cookie:cookies) {
            if(cookie.getName().equals("email")) {
                return userMapping.getUserByEmail(cookie.getName());
            }
        }
        return 0;
    }
}
