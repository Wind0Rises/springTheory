package com.liu.study.spring.mvc.config;

import com.liu.study.spring.mvc.service.PostConstructObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/8/24 11:04
 */
@Configuration
public class PostConstructConfig {

    /**
     * ------ constructor method --------                           构造函数
     * ------ is modified PostConstruct annotation --------         @PostConstruct
     *  ------- this is InitializingBean method ----                InitializingBean
     * ------   this is init method ------                          Spring-initMethod
     */
    @Bean(initMethod = "initMethod")
    public PostConstructObject postConstructObject() {
        return new PostConstructObject();
    }

}