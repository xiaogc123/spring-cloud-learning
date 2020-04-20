package com.xiaogc.servicehi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author xiaogc
 * @Date 2020/4/19
 */
@RestController
public class HiController {

    @Value("${server.port}")
    String port;
    @RequestMapping("hi")
    public Object home(@RequestParam(value = "name") String name){
        return "hi " + name + " ,i am from port:" + port;
    }
}
