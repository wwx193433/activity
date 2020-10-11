package com.hsbc.scott.utils;


import com.hsbc.scott.core.enums.ResultEnum;
import com.hsbc.scott.core.vo.ResultVO;

/**
 * Class
 * Created by wwx193433
 * 2019-08-12 14:59
 */
public class ResultUtil {

    /** 成功返回. */
    public static ResultVO success(Object obj){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMessage("success");
        resultVO.setData(obj);
        return resultVO;
    }

    public static ResultVO success(){
        return success(null);
    }

    /** 错误返回. */
    public static ResultVO error(Integer code, String message){
        ResultVO resultVO = new ResultVO();
        resultVO.setMessage(message);
        resultVO.setCode(code);
        return resultVO;
    }

    /** 错误返回. */
    public static ResultVO error(ResultEnum resultEnum){
        ResultVO resultVO = new ResultVO();
        resultVO.setMessage(resultEnum.getMessage());
        resultVO.setCode(resultEnum.getCode());
        return resultVO;
    }
}
