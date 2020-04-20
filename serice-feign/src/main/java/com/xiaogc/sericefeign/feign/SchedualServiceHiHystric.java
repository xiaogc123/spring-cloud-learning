package com.xiaogc.sericefeign.feign;

import org.springframework.stereotype.Component;

/**
 * @author xiaogc_a
 * @date 2020/4/20 0020 下午 10:24
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }
}
