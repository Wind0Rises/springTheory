package com.liu.study.spring.aop;

/**
 * @desc
 * @author Liuweian
 * @createTime 2020/5/15 21:08
 * @version 1.0.0
 */
public class CustomAspect {
    public void before() {
        System.out.println("CustomAspect ---  前置处理");
    }

    public void after() {
        System.out.println("CustomAspect ---  后置处理");
    }
}
