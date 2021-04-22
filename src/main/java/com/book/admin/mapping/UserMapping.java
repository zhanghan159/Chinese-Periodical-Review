package com.book.admin.mapping;

import com.book.admin.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Mapper
@Component
public interface UserMapping {
    @Select("select * from user where email = #{email} and password = #{password}")
    User getUserByEmailAndPassword(User user);

    @Select("select userIdentity from user where email")
    int getUserByEmail(String name);

    @Insert("insert into user (email, password, userName, sex, jobNumber, telephoneNumber, introduce) " +
            "value (#{email},#{password},#{userName},#{sex},#{jobNumber},#{telephoneNumber},#{introduce})")
    long insert(User user);
}
