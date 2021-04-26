package com.book.admin.mapping;

import com.book.admin.mapping.dao.GroupDaoProvider;
import com.book.admin.model.Group;
import com.book.admin.query.Queryparam;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface GroupMapper {
    @Select("select * from userGroup")
    List<Group> getAll();

    @Update("update userGroup set groupPeopleNumber = #{countByGroup} where groupId = #{groupId}")
    long updateGroupPeopleNumber(int countByGroup,int groupId);

    @SelectProvider(type = GroupDaoProvider.class, method = "queryAllByPage")
    List<Group> queryAllByPage(Queryparam queryparam);

    @SelectProvider(type = GroupDaoProvider.class, method = "getCount")
    int getCount(Queryparam queryparam);

    @Insert("insert into userGroup (groupName, groupLeaderId, groupLeaderName, groupPeopleNumber, introduce) " +
            "VALUE (#{groupName},#{groupLeaderId},#{groupLeaderName},#{groupPeopleNumber},#{introduce}) ")
    long addUserGroup(Group group);

    @Delete("delete from userGroup where groupId = #{groupId}")
    long deleteGroup(int groupId);
}
