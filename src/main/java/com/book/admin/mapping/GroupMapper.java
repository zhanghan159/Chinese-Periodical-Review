package com.book.admin.mapping;

import com.book.admin.mapping.dao.GroupDaoProvider;
import com.book.admin.model.Group;
import com.book.admin.query.Queryparam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface GroupMapper {
    @Select("select * from userGroup")
    List<Group> getAll();

    @Update("update userGroup set groupPeopleNumber = #{countByGroup}")
    long updateGroupPeopleNumber(int countByGroup);

    @SelectProvider(type = GroupDaoProvider.class, method = "queryAllByPage")
    List<Group> queryAllByPage(Queryparam queryparam);

    @SelectProvider(type = GroupDaoProvider.class, method = "getCount")
    int getCount(Queryparam queryparam);
}
