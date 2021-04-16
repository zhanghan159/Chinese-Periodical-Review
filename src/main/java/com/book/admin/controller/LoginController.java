package com.book.admin.controller;

import com.book.admin.model.User;
import com.book.admin.service.LoginService;
import com.book.admin.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("login")
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("userLogin")
    public ResultVO userLogin(User user){
        return loginService.userLogin(user);
    }
}
