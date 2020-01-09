package com.rongrong.springboot.demo.exception;

import com.rongrong.springboot.demo.exceptionenum.ResultEnum;

/**
 * @author rongrong
 * @version 1.0
 * @description:
 * @date 2020/1/10 0:24
 */
public class StudentException extends RuntimeException{
    //code码
    private Integer code;
    //错误信息
    private String msg;

    public StudentException(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
