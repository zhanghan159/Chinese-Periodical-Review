package com.book.admin.service;

import com.book.admin.mapping.UserMapping;
import com.book.admin.model.User;
import com.book.admin.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Service
public class LoginService {

    @Autowired
    private UserMapping userMapping;

    public User userLogin(User user) {
        User user1 = userMapping.getUserByEmailAndPassword(user);

        return user1;
    }
}
