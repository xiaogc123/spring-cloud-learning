package com.xiaogc.nacosconfig.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author xiaogc
 * @Date 2020/5/3
 */
@RestController
@RequestMapping("/config")
@RefreshScope
public class ConfigController {

    @Value("${useLocalCache.info}")
    private String useLocalCache;
 @Value("${config.info}")
    private String config;

    @RequestMapping("/get")
    public String get() {
        return useLocalCache;
    }

    @RequestMapping("/getConfig")
    public String getConfig() {
        return config;
    }
}