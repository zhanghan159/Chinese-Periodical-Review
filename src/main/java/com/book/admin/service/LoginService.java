package com.book.admin.service;

import com.book.admin.mapping.UserMapping;
import com.book.admin.model.User;
import com.book.admin.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Service
public class LoginService {

    @Autowired
    private UserMapping userMapping;

    public ResultVO userLogin(HttpServletResponse response, User user) {
        User user1 = userMapping.getUserByEmailAndPassword(user);
        if (user1 != null) {
            Cookie cookie = new Cookie("userName",user1.getUserName());
            cookie.setMaxAge(1800000);
            response.addCookie(cookie);
            return new ResultVO("登录成功");
        }
        else return new ResultVO("-1","密码或用户名错误");
    }
}
