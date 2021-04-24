package com.book.admin.mapping;

import com.book.admin.model.Group;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface GroupMapper {
    @Select("select * from userGroup")
    List<Group> getAll();
}
