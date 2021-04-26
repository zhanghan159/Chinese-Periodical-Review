package com.book.admin.service;

import com.book.admin.mapping.UserMapper;
import com.book.admin.model.User;
import com.book.admin.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UserMapper userMapper;

    public User userLogin(User user) {
        return userMapper.getUserByEmailAndPassword(user);
    }

    public ResultVO addUser(User user) {
        long insert = userMapper.insert(user);
        if (insert == 0) return new ResultVO("-3","增加失败");
        return new ResultVO();
    }
}
