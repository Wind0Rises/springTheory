package com.liu.study.spring.aop.jdk;

/**
 * @desc
 * @author Liuweian
 * @version 1.0.0
 * @createTime 2020/5/20 13:28
 */
public class OrderAdvisor {

    public void before() {
        System.out.println("--- Order Advisor Before ---");
    }

    public void after() {
        System.out.println("--- Order Advisor After ---");
    }

}
