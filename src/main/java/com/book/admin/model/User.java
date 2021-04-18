package com.book.admin.model;

import lombok.Data;

@Data
public class User {
    private int userId;
    private String email;
    private String password;
    private String userName;
    /**
     *用户身份 0 - 管理者  1 - 审核员  2-访客
     * */
    private int userIdentity;
}
