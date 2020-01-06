package com.rongrong.springboot.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author rongrong
 * @version 1.0
 * @description:
 * @date 2020/1/6 21:50
 */
@Aspect
@Component
public class HttpAspect {

    @Before("execution(public * com.rongrong.springboot.demo.controller.StudentController.*(..))")
    public void log(){
        System.out.println("我执行了！！");
    }
}
