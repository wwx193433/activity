package com.hsbc.scott.core.vo;

import com.hsbc.scott.core.enums.ResultEnum;
import lombok.Data;

/**
 * Class
 * Created by wwx193433
 * 2019-08-12 14:56
 */
@Data
public class ResultVO<T> {

    /** 错误码. */
    private Integer code;

    /** 提示信息. */
    private String message;

    /** 返回的具体内容. */
    private T data;

    public ResultVO(){

    }

    public ResultVO(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    public ResultVO(ResultEnum resultEnum){
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
    }
}
