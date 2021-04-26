package com.book.admin.mapping.dao;

import com.book.admin.model.User;
import com.book.admin.query.FilterParam;
import com.book.admin.query.Queryparam;
import org.apache.ibatis.jdbc.SQL;

/**
 * @ClassName GroupDaoProvider
 * @Description TODO
 * @Author zhanghan.a
 * Data 2021/4/26 11:20
 */
public class GroupDaoProvider {
    public String queryAllByPage(Queryparam queryparam){
        return  new SQL(){
            {
                SELECT("*");
                FROM("userGroup");
                if (!queryparam.getFilterParams().isEmpty()){
                    for (FilterParam filterParam :queryparam.getFilterParams()){
                        if ("groupName".equals(filterParam.getName())){
                            WHERE(filterParam.getName() + " " + filterParam.getRelation() + " " + "'%"+filterParam.getValue()+"%'");
                        }else {
                            WHERE(filterParam.getName() + " " + filterParam.getRelation() + " " + filterParam.getValue());
                        }
                    }
                }
                OFFSET(queryparam.getBegin_number());
                LIMIT(queryparam.getPageSize());

            }
        }.toString();
    }

    public String getCount(Queryparam queryparam){
        return  new SQL(){
            {
                SELECT("count(groupId)");
                FROM("userGroup");
                if (!queryparam.getFilterParams().isEmpty()){
                    for (FilterParam filterParam :queryparam.getFilterParams()){
                        if ("groupName".equals(filterParam.getName())){
                            WHERE(filterParam.getName() + " " + filterParam.getRelation() + " " + "'%"+filterParam.getValue()+"%'");
                        }else {
                            WHERE(filterParam.getName() + " " + filterParam.getRelation() + " " + filterParam.getValue());
                        }
                    }
                }
            }
        }.toString();
    }
}
