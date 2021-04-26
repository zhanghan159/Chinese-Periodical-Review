package com.book.admin.proxy;


import com.book.admin.mapping.GroupMapper;
import com.book.admin.mapping.UserMapper;
import com.book.admin.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



/**
 * @ClassName AutoControlProxy
 * @Description TODO 自动控制所有的系统
 * @Author zhanghan.a
 * Data 2021/4/14 10:53
 */
@Component
public class AutoControlProxy {

    @Autowired
    private GroupMapper groupMapper;

    @Autowired
    private UserMapper userMapper;
    /**
     * 自动更新坟分组人数 十分钟
     */
    @Scheduled(fixedDelay = 600000)
    @Transactional
    public void discardToDye() {
        List<Group> all = groupMapper.getAll();
        all.stream().forEach(
                g -> { groupMapper.updateGroupPeopleNumber(userMapper.getCountByGroup(g.getGroupId()), g.getGroupId());});
        System.out.println("-------------------*******----------------" +
                "\n自动修改组人数");
    }
}
