package com.rongrong.springboot.demo.utils;

import com.rongrong.springboot.demo.domain.Result;

/**
 * @description: 统一格式化输出json
 * @author rongrong
 * @version 1.0
 * @date 2020/1/9 21:55
 */
public class ResultUtils {

    public static Result success(Object obj) {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("success");
        result.setData(obj);
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result error(Integer code,String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        //result.setMsg("unknown error");
        return result;
    }
}
