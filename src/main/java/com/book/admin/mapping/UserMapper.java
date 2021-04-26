package com.book.admin.mapping;

import com.book.admin.mapping.dao.PeriodicalDaoProvider;
import com.book.admin.mapping.dao.UserDaoProvider;
import com.book.admin.model.Periodical;
import com.book.admin.model.User;
import com.book.admin.query.Queryparam;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Component
public interface UserMapper {
    @Select("select * from user where email = #{email} and password = #{password}")
    User getUserByEmailAndPassword(User user);

    @Select("select userIdentity from user where email = #{name}")
    int getUserIdentityByEmail(String name);

    @Insert("insert into user (email, password, userName, sex, jobNumber, telephoneNumber, introduce) " +
            "value (#{email},#{password},#{userName},#{sex},#{jobNumber},#{telephoneNumber},#{introduce})")
    long insert(User user);

    @Select("select * from user where email = #{email}")
    User getUserByEmail(String email);

    @SelectProvider(type = UserDaoProvider.class, method = "queryByPage")
    List<User> queryByPage(Queryparam queryparam);

    @SelectProvider(type = UserDaoProvider.class, method = "getCount")
    int getCount(Queryparam queryparam);

    @Update("update user set groupId = #{groupId} where userId = #{userId}")
    Long updateGroupId(int userId, int groupId);

    @Select("select count(userId) from user where groupId = #{groupId}")
    int getCountByGroup( int groupId);
}
