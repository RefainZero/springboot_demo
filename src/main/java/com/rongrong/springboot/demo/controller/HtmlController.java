package com.rongrong.springboot.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author rongrong
 * @version 1.0
 * @description:
 * @date 2019/12/28 21:32
 */
@Controller
public class HtmlController {

    @RequestMapping(value = "/say",method = RequestMethod.GET)
    public String index(){
        return "index";
    }
}
