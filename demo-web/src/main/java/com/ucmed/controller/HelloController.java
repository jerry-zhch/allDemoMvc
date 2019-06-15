package com.ucmed.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 欢迎页
 */
@Controller
@RequestMapping("/weixin")
public class HelloController {
    @RequestMapping(method = RequestMethod.GET,value = "index.htm")
    public String hello0(){
        return "welcome";
    }
}
