package com.rongrong.springboot.demo.handle;

import com.rongrong.springboot.demo.aspect.HttpAspect;
import com.rongrong.springboot.demo.domain.Result;
import com.rongrong.springboot.demo.exception.StudentException;
import com.rongrong.springboot.demo.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description: 全局异常处理
 * @author rongrong
 * @version 1.0
 * @date 2020/1/10 0:17
 */
@ControllerAdvice
public class ExceptionHandle {

    /**
     * 使用self4j，此日志为spring boot自带的日志框架
     */
    private final static Logger logger= LoggerFactory.getLogger(ExceptionHandle.class);

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Result error(Exception e) {
        if(e instanceof StudentException){
            StudentException studentException=(StudentException)e;
            return ResultUtils.error(studentException.getCode(),studentException.getMsg());
        }else {
            logger.error("系统异常: {} ",e);
            return ResultUtils.error(-1, "unknown error!");
        }
    }
}
