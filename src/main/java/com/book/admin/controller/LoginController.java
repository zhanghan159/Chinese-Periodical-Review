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
    public ResultVO userLogin(HttpServletResponse response,HttpServletRequest request,User user) {
        User user1 = loginService.userLogin(user);
        if (user1 != null) {
            Cookie cookie = new Cookie("user-name",user1.getUserName());
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

    @GetMapping("getUser")
    public ResultVO getUser(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();

        if(cookies==null) {
            return new ResultVO("-2","缺少cookie");
        }else {
            for(Cookie cookie:cookies) {
                if(cookie.getName().equals("user-name")) {
                    return new ResultVO(cookie.getName());
                }
            }
            return new ResultVO("-2","缺少cookie");
        }
    }
}
