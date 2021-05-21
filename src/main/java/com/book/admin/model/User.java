package com.book.admin.model;

import lombok.Data;

@Data
public class User {
    /**
     * 用户id
     */
    private int userId;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 用户密码
     */
    private String password;

    /**
     * '用户身份'
     * 用户身份 0 - 申请用户  1 - 审核员   2 - 管理员  3 - 系统管理员
     */
    private int userIdentity;

    /**
     * 分组id
     */
    private int groupId;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 性别 0-男 1-nv
     */
    private int sex;

    /**
     * '用户工号'
     */
    private int jobNumber;

    /**
     * '电话号码'
     */
    private String telephoneNumber;

    /**
     * '介绍'
     */
    private String introduce;


}
