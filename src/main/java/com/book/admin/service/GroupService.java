package com.book.admin.service;

import com.book.admin.mapping.GroupMapper;
import com.book.admin.model.Group;
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
}
