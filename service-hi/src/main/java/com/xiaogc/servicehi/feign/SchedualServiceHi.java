package com.xiaogc.servicehi.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author xiaogc_a
 * @date 2020/4/20 0020 下午 9:36
 */
@FeignClient(value = "service-feign")
public interface SchedualServiceHi {

    @RequestMapping(value = "/info",method = RequestMethod.GET)
    String info();
}
