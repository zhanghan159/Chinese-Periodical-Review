package com.book.admin.query;

import com.auth0.jwt.internal.org.apache.commons.lang3.StringUtils;
import lombok.Data;


/**
 * @ClassName filterParam
 * @Description TODO 负责接收前段传输数据中的条件查询
 * @Author zhanghan.a
 * Data 2021/3/5 15:54
 */
@Data
public class FilterParam {
    private String name;
    private String relation;
    private Object value;
    /**
     * @Author zhanghan
     * @Description //TODO 对接收到的条件进行判断
     * @Date 16:52 2021/3/5
     * @Param []
     * @return []
     */
    public boolean isEmpty() {
        boolean nameEmpty = StringUtils.isEmpty(name);
        boolean valueEmpty = value instanceof String && StringUtils.isEmpty((String) value);

        if (value == null){
            return true;
        }

//        这一部分暂时用不到,等今后在搞
//        if ("in".equals(relation)){
//            List<String> valueList = castList(value,String.class);
//            if (valueList.get(0)=="")
//                return true;
//        }

        return nameEmpty ||valueEmpty;
    }
}
