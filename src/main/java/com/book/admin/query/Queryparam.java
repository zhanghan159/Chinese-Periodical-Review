package com.book.admin.query;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Queryparam
 * @Description TODO 负责接收前端传输数据
 * @Author zhanghan.a
 * Data 2021/3/5 15:23
 */
@Data
public class Queryparam {
    private int pageSize;
    private int page;
    private int begin_number;
    private List<FilterParam> filterParams = new ArrayList<>();

    public Queryparam() {
    }

    public Queryparam(int pageSize, int page, int begin_number, List<FilterParam> filterParams) {
        this.pageSize = pageSize;
        this.page = page;
        this.begin_number = (page-1)* pageSize;
        this.filterParams = filterParams;
    }

    /**
     * @Author zhanghan
     * @Description //TODO 将filterParams没用的数据给删除了
     * @Date 17:10 2021/3/5
     * @Param []
     * @return []
     */
    public void isFilterParamIsEmpty() {
        for (int i = filterParams.size() - 1; i >= 0; i--) {
            if (filterParams.get(i).isEmpty()) {
                filterParams.remove(i);
            }
        }
    }



}