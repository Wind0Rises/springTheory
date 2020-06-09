package com.liu.study.spring.aop;

import org.springframework.stereotype.Component;

/**
 * @desc 被切的类。
 *       在这个类中织入切面。
 * @author Liuweian
 * @createTime 2020/5/15 20:59
 * @version 1.0.0
 */
public class PointCut {
    public void aopTestMethod() {
        System.out.println("这是被切的类。。。。在这个方法前后织入-----切面");
    }
}
