package com.book.admin.controller;

import com.book.admin.model.User;
import com.book.admin.query.Queryparam;
import com.book.admin.service.CommontService;
import com.book.admin.service.UserService;
import com.book.admin.utils.Loginutil;
import com.book.admin.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

    @PostMapping("queryAllToPass.do")
    public ResultVO queryAllToPass (HttpServletRequest request,@RequestBody Queryparam queryparam) {
        String email = Loginutil.getCookie(request);
        User user = commontService.getUserByEmail(email);
        if (user.getUserIdentity()!=0 && user.getUserIdentity()!=1)
            return userService.queryAllToPass(queryparam , user);
        return new ResultVO("-4","没有权限访问该功能");
    }

    @GetMapping("goingGroup.do")
    public ResultVO goingGroup (HttpServletRequest request,int userId,int groupId) {
        String email = Loginutil.getCookie(request);
        User user = commontService.getUserByEmail(email);
        if (user.getUserIdentity()!=0 && user.getUserIdentity()!=1)
            return userService.goingGroup(userId , groupId);
        return new ResultVO("-4","没有权限访问该功能");
    }

    @PostMapping("queryAllNotPass.do")
    public ResultVO queryAllNotPass (HttpServletRequest request,@RequestBody Queryparam queryparam) {
        String email = Loginutil.getCookie(request);
        User user = commontService.getUserByEmail(email);
        if (user.getUserIdentity()!=0 && user.getUserIdentity()!=1)
            return userService.queryAllNotPass(queryparam);
        return new ResultVO("-4","没有权限访问该功能");
    }

    @GetMapping("pass.do")
    public ResultVO pass (HttpServletRequest request,int userId) {
        String email = Loginutil.getCookie(request);
        User user = commontService.getUserByEmail(email);
        if (user.getUserIdentity()!=0 && user.getUserIdentity()!=1)
            return userService.pass(userId);
        return new ResultVO("-4","没有权限访问该功能");
    }

    @GetMapping("modifyUserIdentity.do")
    public ResultVO modifyUserIdentity (HttpServletRequest request,int userId,int userIdentity) {
        String email = Loginutil.getCookie(request);
        User user = commontService.getUserByEmail(email);
        if (user.getUserIdentity() == 3)
            return userService.modifyUserIdentity(userId,userIdentity);
        return new ResultVO("-4","没有权限访问该功能");
    }

    @RequestMapping("outToUser.do")
    public ResultVO outToUser (HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = Loginutil.getCookie(request);
        User user = commontService.getUserByEmail(email);
        Cookie[] cookies = request.getCookies();
        if (cookies.length == 0) return new ResultVO("-5","操作错误");
        for (Cookie cookie: cookies) {
            if ("email".equals(cookie.getName())) {
                cookie.setValue(null);
                cookie.setMaxAge(0);
                response.addCookie(cookie);
                return new ResultVO("退出成功");
            }
        }
        return new ResultVO("-4","操作错误");
    }
}
