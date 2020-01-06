package com.rongrong.springboot.demo.controller;

import com.rongrong.springboot.demo.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author rongrong
 * @version 1.0
 * @description:
 * @date 2019/12/26 20:34
 */
@RestController
/**
 * 在类上方使用，如在该处添加，接口访问时采取路径拼接方式访问
 * 如：localhost:8888/spring/hellow
 */
@RequestMapping("/spring")
public class HellowController {


    @Autowired
    Person person;

    //在方法 上方使用
    @RequestMapping(value = "/hellow", method = RequestMethod.GET)
    public String say() {
        return person.getGName();
    }

    //Restful风格接口
    @RequestMapping(value = "/getID/{id}", method = RequestMethod.GET)
    public String getID(@PathVariable("id") Integer id) {
        return "Id:"+id;
    }

    /***
     * 传统方式接口
     * @RequestParam(value = "id",required = false,defaultValue = "0")
     * value为传入字段名，required为true时必须传参，defaultValue为传入参数默认值
     * @param id
     * @return
     */
    @RequestMapping(value = "/getMyId", method = RequestMethod.GET)
    public String getMyId(@RequestParam(value = "id",required = false,defaultValue = "0") Integer id) {
        return "getMyId: \t"+id;
    }

    /**
     * 组合注解及多个路径可以访问同一个接口
     * @param id
     * @return
     */
    @GetMapping({"/getUserId","/sayhi"})
    //@RequestMapping(value = "/getMyId", method = RequestMethod.GET)
    public String getUserId(@RequestParam(value = "id",required = false,defaultValue = "0") Integer id) {
        return "getMyId: \t"+id;
    }


}
