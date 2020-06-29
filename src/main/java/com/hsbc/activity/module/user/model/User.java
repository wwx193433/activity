package com.hsbc.activity.module.user.model;

import lombok.Data;

import java.io.Serializable;


@Data
public class User implements Serializable {
    private Integer id;

    private String name;

    private String account;

    private Integer status;

    private String createTime;

}