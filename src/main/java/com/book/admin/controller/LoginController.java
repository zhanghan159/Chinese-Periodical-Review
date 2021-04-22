package com.book.admin.controller;

import com.book.admin.model.User;
import com.book.admin.service.LoginService;
import com.book.admin.utils.Loginutil;
import com.book.admin.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping("login")
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("userLogin")
    public ResultVO userLogin(HttpServletResponse response,User user) {
        User user1 = loginService.userLogin(user);
        if (user1 != null) {
            Cookie cookie = new Cookie("email",user1.getUserName());
            cookie.setMaxAge(180000);
            cookie.setPath("/");
            cookie.setDomain("localhost");
            response.addCookie(cookie);
            return new ResultVO("登录成功");
        }else
        {
            return new ResultVO("-1","登录失败");
        }

    }

    @PostMapping("addUser")
    public ResultVO addUser(@RequestBody User user) {
        loginService.addUser(user);
        return new ResultVO("添加成功返回界面");
    }

}
