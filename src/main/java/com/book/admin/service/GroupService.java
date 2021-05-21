package com.book.admin.service;

import com.book.admin.mapping.GroupMapper;
import com.book.admin.mapping.PeriodicalMapper;
import com.book.admin.mapping.UserMapper;
import com.book.admin.model.Group;
import com.book.admin.model.Periodical;
import com.book.admin.query.PagerHelper;
import com.book.admin.query.Queryparam;
import com.book.admin.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GroupService {
    @Autowired
    private GroupMapper groupMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PeriodicalMapper periodicalMapper;

    public ResultVO getAll() {
        List<Group> list =  groupMapper.getAll();
        return new ResultVO(list);
    }

    public ResultVO queryAllByPage(Queryparam queryparam) {
        queryparam.isFilterParamIsEmpty();
        queryparam.setBegin_number();
        List<Group> groups = groupMapper.queryAllByPage(queryparam);
        int count = groupMapper.getCount(queryparam);
        PagerHelper<Group> groupPagerHelper= new PagerHelper<>(groups,count, queryparam.getPageSize());
        return new ResultVO(groupPagerHelper);
    }

    public ResultVO addUserGroup(Group group) {
        groupMapper.addUserGroup(group);
        return new ResultVO();
    }

    @Transactional
    public ResultVO deleteGroup(int groupId) {
        periodicalMapper.updateGroupIdByGroupId(groupId,0);
        userMapper.updateGroupIdByGroupId(groupId,0);
        groupMapper.deleteGroup(groupId);
        return new ResultVO();
    }
}
