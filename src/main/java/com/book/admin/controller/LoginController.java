package com.book.admin.controller;

import com.book.admin.model.User;
import com.book.admin.service.LoginService;
import com.book.admin.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return loginService.userLogin(response,user);
    }

    @GetMapping("test000")
    public ResultVO test000(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        return new ResultVO(cookies);
    }
}
