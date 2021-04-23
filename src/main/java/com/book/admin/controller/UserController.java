package com.book.admin.controller;

import com.book.admin.model.User;
import com.book.admin.service.CommontService;
import com.book.admin.service.UserService;
import com.book.admin.utils.Loginutil;
import com.book.admin.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author zhanghan.a
 * Data 2021/4/23 10:20
 */

@RequestMapping("user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private CommontService commontService;

    @GetMapping("getUser.do")
    public ResultVO getUser (HttpServletRequest request) {
        String email = Loginutil.getCookie(request);
        User user = commontService.getUserByEmail(email);
        return new ResultVO(user);
    }

}
