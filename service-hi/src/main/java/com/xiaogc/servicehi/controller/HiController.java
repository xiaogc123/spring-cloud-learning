package com.xiaogc.servicehi.controller;

import com.xiaogc.servicehi.feign.SchedualServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * @Author xiaogc
 * @Date 2020/4/19
 */

@RestController
public class HiController {

    @Autowired
    SchedualServiceHi schedualServiceHi;

    private static final Logger LOG = Logger.getLogger(HiController.class.getName());
    @Value("${server.port}")
    String port;
    @RequestMapping("hi")
    public Object home(@RequestParam(value = "name") String name){
        LOG.log(Level.INFO, "calling trace service-hi  ");
        return "hi " + name + " ,i am from port:" + port;
    }

    @RequestMapping("/info")
    public String info(){
        LOG.log(Level.INFO, "info is being called");
      return schedualServiceHi.info();

    }
}
