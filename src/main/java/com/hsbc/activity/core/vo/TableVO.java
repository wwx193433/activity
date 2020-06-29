package com.hsbc.activity.core.vo;

import lombok.Data;

/**
 * Class
 * Created by wwx193433
 * 2019-08-12 14:56
 */
@Data
public class TableVO<T> {

    /** 错误码. */
    private Integer code;

    /** 提示信息. */
    private String msg;

    /** 返回的具体内容. */
    private T data;

    /**
     * 数据总数
     */
    private Long count;
}
