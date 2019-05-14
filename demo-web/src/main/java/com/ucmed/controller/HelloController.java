package com.ucmed.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/weixin")
public class HelloController {
    private static final Logger log=Logger.getLogger("HelloController");
    @RequestMapping(method = RequestMethod.GET,value = "index.htm")
    public String hello0(){
        return "test";
    }

    @RequestMapping(method = RequestMethod.GET,value = "test.htm")
    @ResponseBody
    public String hello(){
        log.info("1111111111111");
        return "1111111111111111111111";
    }

}
