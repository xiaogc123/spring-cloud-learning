package com.xiaogc.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaogc_a
 * @date 2020/4/21 0021 下午 10:25
 */
@RestController
@RefreshScope
public class HiController {

    @Value("${foo}")
    String foo;

    @Value("${democonfigclient.message}")
    String message;
    @RequestMapping(value = "/hi")
    public String hi(){
        return foo;
    }

    @RequestMapping("msg")
    public String msg(){
        return message;
    }

}
