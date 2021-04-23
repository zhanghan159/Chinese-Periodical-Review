package com.book.admin.service;

import com.book.admin.mapping.UserMapping;
import com.book.admin.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName CommontController
 * @Description TODO
 * @Author zhanghan.a
 * Data 2021/4/23 11:50
 */
@Service
public class CommontService {
    @Autowired
    private UserMapping userMapping;

    public  int getUserIdentity(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if(cookies==null) {
            return 0;
        }
        for(Cookie cookie:cookies) {
            if(cookie.getName().equals("email")) {
                return userMapping.getUserIdentityByEmail(cookie.getName());
            }
        }
        return 0;
    }

    public User getUserByEmail (String email) {
        return userMapping.getUserByEmail(email);
    }


}
