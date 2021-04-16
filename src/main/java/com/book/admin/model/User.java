package com.book.admin.model;

import lombok.Data;

@Data
public class User {
    private int userId;
    private String email;
    private String password;
}
