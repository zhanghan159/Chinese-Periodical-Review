package com.book.admin.controller;

import com.book.admin.model.Periodical;
import com.book.admin.model.User;
import com.book.admin.query.ModifyParam;
import com.book.admin.query.Queryparam;
import com.book.admin.service.CommontService;
import com.book.admin.service.PeriodicalService;
import com.book.admin.utils.Loginutil;
import com.book.admin.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("periodical")
@RestController
public class PeriodicalController {
    @Autowired
    private CommontService commontService;

    @Autowired
    private PeriodicalService periodicalService;

    @PostMapping("queryAll.do")
    public ResultVO queryAll (HttpServletRequest request,@RequestBody Queryparam queryparam) {
        String email = Loginutil.getCookie(request);
        User user = commontService.getUserByEmail(email);
        if (user.getUserIdentity()!=0)
            return periodicalService.queryByPage(queryparam , user);
        return new ResultVO("-4","没有权限访问该功能");
    }

    @PostMapping("examinePeriodical.do")
    public ResultVO examinePeriodical (HttpServletRequest request,@RequestBody Periodical periodical) {
        String email = Loginutil.getCookie(request);
        User user = commontService.getUserByEmail(email);
        if (user.getUserIdentity()!=0)
            return periodicalService.examinePeriodical(periodical , user);
        return new ResultVO("-4","没有权限访问该功能");
    }

    @GetMapping("downloadPeriodical.do")
    public ResultVO downloadPeriodical(HttpServletRequest request, HttpServletResponse response,String urlName ) {
        String email = Loginutil.getCookie(request);
        User user = commontService.getUserByEmail(email);
        if (user.getUserIdentity()!=0)
            return periodicalService.downloadPeriodical(response,urlName);
        return new ResultVO("-4","没有权限访问该功能");
    }

    @PostMapping("queryAllToManger.do")
    public ResultVO queryAllToManger (HttpServletRequest request,@RequestBody Queryparam queryparam) {
        String email = Loginutil.getCookie(request);
        User user = commontService.getUserByEmail(email);
        if (user.getUserIdentity()!=0 || user.getUserIdentity() != 1 )
            return periodicalService.queryAllToManger(queryparam);
        return new ResultVO("-4","没有权限访问该功能");
    }

    @PostMapping("goingToGroup.do")
    public ResultVO goingToGroup (HttpServletRequest request, @RequestBody ModifyParam modifyParam) {
        String email = Loginutil.getCookie(request);
        User user = commontService.getUserByEmail(email);
        if (user.getUserIdentity()!=0 || user.getUserIdentity() != 1 ) {
            List<Integer> collect = modifyParam.getPeriodicals().
                    stream().map(p -> p.getPeriodicalId()).collect(Collectors.toList());
            return periodicalService.goingToGroup(collect,modifyParam.getGroupId());
        }
        return new ResultVO("-4","没有权限访问该功能");
    }
}
