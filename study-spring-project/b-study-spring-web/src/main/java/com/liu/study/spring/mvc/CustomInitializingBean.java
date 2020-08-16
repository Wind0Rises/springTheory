package com.liu.study.spring.mvc;

import org.springframework.beans.factory.InitializingBean;

/**
 * @desc 
 * @author Liuweian
 * @createTime 2020/5/24 9:57
 * @version 1.0.0
 */
public class CustomInitializingBean implements InitializingBean {

    static {
        System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
    }

    public CustomInitializingBean() {
        System.out.println("TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT");
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
