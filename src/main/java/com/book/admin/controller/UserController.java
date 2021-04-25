package com.book.admin.controller;

import com.book.admin.model.User;
import com.book.admin.query.Queryparam;
import com.book.admin.service.CommontService;
import com.book.admin.service.UserService;
import com.book.admin.utils.Loginutil;
import com.book.admin.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("queryAllToPass.do")
    public ResultVO queryAllToPass (HttpServletRequest request,@RequestBody Queryparam queryparam) {
        String email = Loginutil.getCookie(request);
        User user = commontService.getUserByEmail(email);
        if (user.getUserIdentity()!=0 || user.getUserIdentity()!=1)
            return userService.queryAllToPass(queryparam , user);
        return new ResultVO("-4","没有权限访问该功能");
    }

    @PostMapping("goingGroup.do")
    public ResultVO goingGroup (HttpServletRequest request,int userId,int groupId) {
        String email = Loginutil.getCookie(request);
        User user = commontService.getUserByEmail(email);
        if (user.getUserIdentity()!=0 || user.getUserIdentity()!=1)
            return userService.goingGroup(userId , groupId);
        return new ResultVO("-4","没有权限访问该功能");
    }


}
