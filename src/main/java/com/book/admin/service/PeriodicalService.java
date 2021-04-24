package com.book.admin.service;

import com.book.admin.mapping.PeriodicalMapper;
import com.book.admin.model.Periodical;
import com.book.admin.model.User;
import com.book.admin.query.PagerHelper;
import com.book.admin.query.Queryparam;
import com.book.admin.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PeriodicalService {
    @Autowired
    private PeriodicalMapper periodicalMapper;

    public ResultVO queryByPage(Queryparam queryparam, User user) {
        queryparam.isFilterParamIsEmpty();
        List<Periodical> all = periodicalMapper.queryByPage(queryparam,user);
        int count = periodicalMapper.getCount(queryparam,user);
        PagerHelper<Periodical> periodicalPagerHelper= new PagerHelper<>(all,count, queryparam.getPageSize());
        return new ResultVO(periodicalPagerHelper);
    }

    public ResultVO examinePeriodical(Periodical periodical, User user) {
        periodical.setOperateTime(new Date());
        periodical.setUserId(user.getUserId());
        periodical.setUserName(user.getUserName());
        long i = periodicalMapper.updata(periodical);
        if (i != 0 )return new ResultVO();
        return new ResultVO("-5","修改失败");
    }
}
