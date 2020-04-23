package com.xiaogc.sericefeign.controller;

import com.xiaogc.sericefeign.feign.SchedualServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * @author xiaogc_a
 * @date 2020/4/20 0020 下午 9:39
 */
@RestController
public class HiController {
    private static final Logger LOG = Logger.getLogger(HiController.class.getName());
    //编译器报错，无视。 因为这个Bean是在程序启动的时候注入的，编译器感知不到，所以报错。
    @Autowired
    SchedualServiceHi schedualServiceHi;

    @GetMapping(value = "/hi")
    public String sayHi(@RequestParam String name) {
        LOG.log(Level.INFO, "hi is being called");
        return schedualServiceHi.sayHiFromClientOne( name );
    }

    @RequestMapping("/info")
    public String info(){
        LOG.log(Level.INFO, "calling trace service-feign ");

        return "i'm service-feign";

    }
}
