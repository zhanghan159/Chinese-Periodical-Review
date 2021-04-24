package com.book.admin.controller;

import com.book.admin.model.Periodical;
import com.book.admin.model.User;
import com.book.admin.query.Queryparam;
import com.book.admin.service.CommontService;
import com.book.admin.service.PeriodicalService;
import com.book.admin.utils.Loginutil;
import com.book.admin.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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
}
