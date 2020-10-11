package com.hsbc.scott.core.enums;

import lombok.Getter;

/**
 * Class
 * Created by wwx193433
 * 2019-08-15 19:16
 */

@Getter
public enum ResultEnum {



    UNKNOWN_ERROR(-1, "未知错误"),
    SUCCESS(0, "成功"),

    UNKNOWN_USER(1001, "未知账户"),
    WRONG_PASSWORD(1002, "密码错误"),
    LOCKED_USER(1003, "账户已锁定"),
    AUTHORIZE_FAILED(1004, "用户验证失败"),
    LOGOUT(1004, "用户退出"),

    ;
    //错误码
    private Integer code;

    //错误信息
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }}
