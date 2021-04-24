package com.book.admin.model;

import lombok.Data;

@Data
public class Group {

    /**
     * 分组id
     */
    private int groupId;

    /**
     * 分组名字
     */
    private String groupName;

    /**
     * 组长id
     */
    private int groupLeaderId;

    /**
     * 组长姓名
     */
    private String groupLeaderName;

    /**
     * 分组人数
     */
    private int groupPeopleNumber;

    /**
     * 介绍
     */
    private String introduce;
}
