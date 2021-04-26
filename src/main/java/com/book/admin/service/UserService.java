package com.book.admin.service;

import com.book.admin.mapping.UserMapper;
import com.book.admin.model.User;
import com.book.admin.query.PagerHelper;
import com.book.admin.query.Queryparam;
import com.book.admin.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author zhanghan.a
 * Data 2021/4/23 10:21
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public ResultVO queryAllToPass(Queryparam queryparam, User user) {
        queryparam.isFilterParamIsEmpty();
        List<User> all = userMapper.queryByPage(queryparam);
        int count = userMapper.getCount(queryparam);
        PagerHelper<User> userPagerHelper= new PagerHelper<>(all,count, queryparam.getPageSize());
        return new ResultVO(userPagerHelper);
    }

    @Transactional
    public ResultVO goingGroup(int userId, int groupId) {
        Long i = userMapper.updateGroupId (userId,groupId);
        return new ResultVO();
    }
}
