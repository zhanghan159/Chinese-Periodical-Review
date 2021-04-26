package com.book.admin.mapping.dao;

import com.book.admin.model.User;
import com.book.admin.query.FilterParam;
import com.book.admin.query.Queryparam;
import org.apache.ibatis.jdbc.SQL;

public class UserDaoProvider {
    public String queryByPage(Queryparam queryparam){
        return  new SQL(){
            {
                SELECT("*");
                FROM("user");
                if (!queryparam.getFilterParams().isEmpty()){
                    for (FilterParam filterParam :queryparam.getFilterParams()){
                        if ("userName".equals(filterParam.getName())){
                            WHERE(filterParam.getName() + " " + filterParam.getRelation() + " " + "'%"+filterParam.getValue()+"%'");
                        }else {
                            WHERE(filterParam.getName() + " " + filterParam.getRelation() + " " + filterParam.getValue());
                        }
                    }
                }
                WHERE("userIdentity <> 0" );
                OFFSET(queryparam.getBegin_number());
                LIMIT(queryparam.getPageSize());

            }
        }.toString();
    }

    public String getCount(Queryparam queryparam){
        return  new SQL(){
            {
                SELECT("count(userId)");
                FROM("user");
                if (!queryparam.getFilterParams().isEmpty()){
                    for (FilterParam filterParam :queryparam.getFilterParams()){
                        if ("userName".equals(filterParam.getName())){
                            WHERE(filterParam.getName() + " " + filterParam.getRelation() + " " + "'%"+filterParam.getValue()+"%'");
                        }else {
                            WHERE(filterParam.getName() + " " + filterParam.getRelation() + " " + filterParam.getValue());
                        }
                    }
                }
                WHERE("userIdentity <> 0" );
            }
        }.toString();
    }

    public String queryAllNotPass(Queryparam queryparam){
        return  new SQL(){
            {
                SELECT("*");
                FROM("user");
                if (!queryparam.getFilterParams().isEmpty()){
                    for (FilterParam filterParam :queryparam.getFilterParams()){
                        if ("userName".equals(filterParam.getName())){
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

    public String queryAllNotPassCount(Queryparam queryparam){
        return  new SQL(){
            {
                SELECT("count(userId)");
                FROM("user");
                if (!queryparam.getFilterParams().isEmpty()){
                    for (FilterParam filterParam :queryparam.getFilterParams()){
                        if ("userName".equals(filterParam.getName())){
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
