package com.book.admin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("login")
@RestController
public class LoginController {

    @GetMapping("userLogin")
    public int userLogin(){
        return 1;
    }
}
