package com.book.admin.query;

import lombok.Data;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Author zhanghan
 * @Description //TODO 负责分页查询
 * @Date 14:11 2021/3/5
 * @Param 
 * @return 
 */
@Data
public class PagerHelper<T> {
    private List<T> items;
    private long total;
    private int totalPages;
    private int pageSize;


    public PagerHelper(List<T> items, long total, int pageSize) {
        this.items = items;
        this.total = total;
        this.pageSize = pageSize > 0 ? pageSize : 1;
        this.totalPages = (int) ((total - 1) / this.pageSize + 1);
    }

    public <R> PagerHelper<R> toVO(Function<T, R> function) {
        List<R> vos = this.items.stream().map(function::apply).collect(Collectors.toList());
        return new PagerHelper<>(vos, this.total, this.pageSize);
    }
}
