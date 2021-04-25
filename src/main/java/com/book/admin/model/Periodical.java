package com.book.admin.model;

import lombok.Data;

import java.util.Date;

@Data
public class Periodical {
    /**
     * 期刊id
     */
    private int periodicalId;

    /**
     * 期刊名字
     */
    private String periodicalName;

    /**
     * 分配分组Id
     */
    private int groupId;

    /**
     * 期刊类别
     */
    private int periodicalType;

    /**
     * 期刊状态
     * 0-未审核 1-审核通过 2-审核未通过 3-打回修改
     */
    private int periodicalStatus;

    /**
     * 期刊格式内容是否达标
     */
    private int fm;

    /**
     * 期刊内容是否符合主题
     */
    private int ct;

    /**
     * 期刊内容是否原创
     */
    private int ol;

    /**
     * 期刊评分
     * 满分五分
     */
    private int score;

    /**
     * 评价
     */
    private String evaluate;

    /**
     * 送审时间
     */
    private Date censorshipTime;

    /**
     * 审核员id
     */
    private int userId;

    /**
     * 审核员姓名
     */
    private String userName;

    /**
     * 操作时间
     */
    private Date operateTime;

    /**
     * 期刊下载名字
     */
    private String urlName;

}
