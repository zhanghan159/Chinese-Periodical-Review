package com.book.admin.mapping.dao;

import com.book.admin.model.User;
import com.book.admin.query.FilterParam;
import com.book.admin.query.Queryparam;
import org.apache.ibatis.jdbc.SQL;

public class PeriodicalDaoProvider {
    public String queryByPage(Queryparam queryparam, User user){
        return  new SQL(){
            {
                SELECT("*");
                FROM("periodical");
                if (!queryparam.getFilterParams().isEmpty()){
                    for (FilterParam filterParam :queryparam.getFilterParams()){
                        if ("name".equals(filterParam.getName())){
                            WHERE(filterParam.getName() + " " + filterParam.getRelation() + " " + "'%"+filterParam.getValue()+"%'");
                        }else {
                            WHERE(filterParam.getName() + " " + filterParam.getRelation() + " " + filterParam.getValue());
                        }
                    }
                }
                WHERE("groupId = " + user.getGroupId());
                OFFSET(queryparam.getBegin_number());
                LIMIT(queryparam.getPageSize());

            }
        }.toString();
    }

    public String getCount(Queryparam queryparam,User user){
        return  new SQL(){
            {
                SELECT("count(periodicalId)");
                FROM("periodical");
                if (!queryparam.getFilterParams().isEmpty()){
                    for (FilterParam filterParam :queryparam.getFilterParams()){
                        if ("name".equals(filterParam.getName())){
                            WHERE(filterParam.getName() + " " + filterParam.getRelation() + " " + "'%"+filterParam.getValue()+"%'");
                        }else {
                            WHERE(filterParam.getName() + " " + filterParam.getRelation() + " " + filterParam.getValue());
                        }
                    }
                }
                WHERE("groupId = " + user.getGroupId());
            }
        }.toString();
    }

    public String queryAllToManger(Queryparam queryparam){
        return  new SQL(){
            {
                SELECT("*");
                FROM("periodical");
                if (!queryparam.getFilterParams().isEmpty()){
                    for (FilterParam filterParam :queryparam.getFilterParams()){
                        if ("name".equals(filterParam.getName())){
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

    public String getToMangerCount(Queryparam queryparam){
        return  new SQL(){
            {
                SELECT("count(periodicalId)");
                FROM("periodical");
                if (!queryparam.getFilterParams().isEmpty()){
                    for (FilterParam filterParam :queryparam.getFilterParams()){
                        if ("name".equals(filterParam.getName())){
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
