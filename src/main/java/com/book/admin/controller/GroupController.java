package com.book.admin.controller;

import com.book.admin.model.Group;
import com.book.admin.model.User;
import com.book.admin.query.Queryparam;
import com.book.admin.service.CommontService;
import com.book.admin.service.GroupService;
import com.book.admin.utils.Loginutil;
import com.book.admin.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName GroupController
 * @Description TODO
 * @Author zhanghan.a
 * Data 2021/4/23 10:19
 */
@RequestMapping("userGroup")
@RestController
public class GroupController {
    @Autowired
    private CommontService commontService;

    @Autowired
    private GroupService groupService;

    @GetMapping("getAll.do")
    public ResultVO getAll (HttpServletRequest request) {
        String email = Loginutil.getCookie(request);
        User user = commontService.getUserByEmail(email);
        if (user.getUserIdentity()!=0 || user.getUserIdentity()!=1)
            return groupService.getAll();
        return new ResultVO(user);
    }

    @PostMapping("queryAllByPage.do")
    public ResultVO queryAllByPage(HttpServletRequest request,@RequestBody Queryparam queryparam) {
        String email = Loginutil.getCookie(request);
        User user = commontService.getUserByEmail(email);
        if (user.getUserIdentity()!=0 || user.getUserIdentity()!=1)
            return groupService.queryAllByPage(queryparam);
        return new ResultVO(user);
    }

    @PostMapping("addUserGroup.do")
    public ResultVO addUserGroup(HttpServletRequest request,@RequestBody Group group) {
        String email = Loginutil.getCookie(request);
        User user = commontService.getUserByEmail(email);
        if (user.getUserIdentity()!=0 || user.getUserIdentity()!=1)
            return groupService.addUserGroup(group);
        return new ResultVO(user);
    }

    @GetMapping("delete.do")
    public ResultVO deleteGroup(HttpServletRequest request,int groupId) {
        String email = Loginutil.getCookie(request);
        User user = commontService.getUserByEmail(email);
        if (user.getUserIdentity()!=0 || user.getUserIdentity()!=1)
            return groupService.deleteGroup(groupId);
        return new ResultVO(user);
    }
}
