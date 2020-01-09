package com.rongrong.springboot.demo.domain;

import lombok.Data;

/**
 * @description: 最外层对象
 * @author rongrong
 * @version 1.0
 * @date 2020/1/9 21:51
 */
@Data
public class Result<T> {
    //code码
    private Integer code;
    //错误信息
    private String msg;
    //返回实体对象
    private T data;
}
