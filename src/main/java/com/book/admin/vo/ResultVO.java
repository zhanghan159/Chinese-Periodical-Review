package com.book.admin.vo;

import lombok.Data;

@Data
public class ResultVO {
    private String status;
    private String msg;
    private Object data;

    public ResultVO(){
        this.status = "0";
        this.msg = "success";
    }

    public ResultVO(Object data) {
        this.status = "0";
        this.msg = "success";
        this.data = data;
    }

    public ResultVO(String code, String msg, Object data) {
        this.status = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultVO(String code, String msg) {
        this.status = code;
        this.msg = msg;
    }
}
