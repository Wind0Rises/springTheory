package com.liu.study.spring.mvc.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * ------ constructor method --------
 * ------ is modified PostConstruct annotation --------
 *  ------- this is InitializingBean method ----
 * ------   this is init method ------
 *
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/8/24 10:31
 */
public class PostConstructObject implements InitializingBean {


    public PostConstructObject() {
        System.out.println("------ constructor method --------");
    }

    /**
     * 只能作用在分静态的void的方法。public、protected、private修饰都可以。可以是final的。
     * 此注解是在Java EE5规范中加入的，在Servlet生命周期中有一定作用，它通常都是一些初始化的操作，【【但初始化可能依赖于注入的其他组件，所以要等依赖全部加载完再执行】】。
     * 在依赖注入完成以后，调用一次。
     */
    @PostConstruct
    public void postConstructMethod() {
        System.out.println("------ is modified PostConstruct annotation --------");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("------ is modified PreDestroy annotation --------");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(" ------- this is InitializingBean method ----");
    }


    private void initMethod() {
        System.out.println("------   this is init method ------");
    }
}