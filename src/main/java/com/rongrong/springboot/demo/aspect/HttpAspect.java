package com.rongrong.springboot.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.jws.Oneway;
import javax.servlet.http.HttpServletRequest;

/**
 * @author rongrong
 * @version 1.0
 * @description:
 * @date 2020/1/6 21:50
 */
@Aspect
@Component
public class HttpAspect {

    /**
     * 使用self4j，此日志为spring boot自带的日志框架
     */
    private final static Logger logger= LoggerFactory.getLogger(HttpAspect.class);

    /**
     *此处为了简化代码，提高维护性，还是需要提炼下的
    @Before("execution(public * com.rongrong.springboot.demo.controller.StudentController.*(..))")
    public void log(){
        System.out.println("我执行了！！");
    }
     */

    @Pointcut("execution(public * com.rongrong.springboot.demo.controller.StudentController.*(..))")
    public void log(){
    }

    /**
     * 在接口执行操作时输出相关参数
     */
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        //使用RequestContextHolder来获得请求属性，这里需要强转成ServletRequestAttributes对象
        ServletRequestAttributes servletRequestAttributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        //获取请求url
        String url = servletRequestAttributes.getRequest().getRequestURI();
        //获取请求IP
        String addr = servletRequestAttributes.getRequest().getRemoteAddr();
        //获取请求方法
        String method = servletRequestAttributes.getRequest().getMethod();
        //获取类名
        String pCName = joinPoint.getSignature().getDeclaringTypeName();
        //获取类方法
        String cName = joinPoint.getSignature().getName();
        //这里要说明下 logger.info("url={}",url)，url为{}自动填充部分
        //url
        logger.info("url= {}",url);
        //ip
        logger.info("ip= {}",addr);
        //method
        logger.info("method= {}",method);
        //args
        //获取请求参数
        logger.info("args= {}",joinPoint.getArgs());
        //类名和类方法
        logger.info("类名和类方法= {}",pCName+"."+cName);
    }

    @After("log()")
    public void doAfter(){
        logger.info("doAfter ：我执行了！！");
    }

    /**
     * 使用@AfterReturning，获取返回相应信息
     */
    @AfterReturning(returning = "object",pointcut="log()")
    public void doAfterReturning(Object object){
        logger.info("返回信息 ：{}",object.toString());
    }
}
