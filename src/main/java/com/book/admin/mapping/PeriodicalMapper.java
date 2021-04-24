package com.book.admin.mapping;

import com.book.admin.mapping.dao.PeriodicalDaoProvider;
import com.book.admin.model.Periodical;
import com.book.admin.model.User;
import com.book.admin.query.Queryparam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface PeriodicalMapper {
    @SelectProvider(type = PeriodicalDaoProvider.class, method = "queryByPage")
    List<Periodical> queryByPage(Queryparam queryparam, User user);

    @SelectProvider(type = PeriodicalDaoProvider.class, method = "getCount")
    int getCount(Queryparam queryparam,User user);
}
