package com.book.admin.query;

import com.book.admin.model.Periodical;
import lombok.Data;

import java.util.List;

/**
 * @ClassName ModifyParams
 * @Description TODO
 * @Author zhanghan.a
 * Data 2021/4/26 17:09
 */
@Data
public class ModifyParam {
    private List<Periodical> periodicals;
    private int groupId;
}
