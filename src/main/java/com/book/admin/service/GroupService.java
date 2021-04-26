package com.book.admin.service;

import com.book.admin.mapping.GroupMapper;
import com.book.admin.model.Group;
import com.book.admin.model.Periodical;
import com.book.admin.query.PagerHelper;
import com.book.admin.query.Queryparam;
import com.book.admin.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {
    @Autowired
    private GroupMapper groupMapper;

    public ResultVO getAll() {
        List<Group> list =  groupMapper.getAll();
        return new ResultVO(list);
    }

    public ResultVO queryAllByPage(Queryparam queryparam) {
        queryparam.isFilterParamIsEmpty();
        List<Group> groups = groupMapper.queryAllByPage(queryparam);
        int count = groupMapper.getCount(queryparam);
        PagerHelper<Group> groupPagerHelper= new PagerHelper<>(groups,count, queryparam.getPageSize());
        return new ResultVO(groupPagerHelper);
    }
}
