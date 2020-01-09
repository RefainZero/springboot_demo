package com.rongrong.springboot.demo.exceptionenum;

/**
 * @author rongrong
 * @version 1.0
 * @description:
 * @date 2020/1/9 23:11
 */

public enum ResultEnum {

    UNKNOW_ERROR(-1,"unknown error!"),
    HIGH_SCHOOL(10001,"应该上小学啦！"),
    PRIMARY_SCHOOL(10002,"应该上初中啦！"),
    SUCCESS(0,"success");
    //code码
    private Integer code;
    //错误信息
    private String msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
