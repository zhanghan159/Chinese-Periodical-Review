package com.book.admin.service;

import com.book.admin.mapping.UserMapping;
import com.book.admin.model.User;
import com.book.admin.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UserMapping userMapping;

    public ResultVO userLogin(User user) {
        User user1 = userMapping.getUserByEmailAndPassword(user);
        if (user1 != null) return new ResultVO("登录成功");
        else return new ResultVO("-1","密码或用户名错误");
    }
}
