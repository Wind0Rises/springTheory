package com.liu.study.spring.aop.cglib;

/**
 * @desc 被代理类。
 *          Cglib是无法处理final修饰的方法的。
 * @author Liuweian
 * @version 1.0.0
 * @createTime 2019/12/30 10:40
 */
public class CustomByProxyClass {

    public CustomByProxyClass() {
        System.out.println("被代理类的构造函数。");
    }

    public void customByProxyMethod() {
        System.out.println("被代理类中的方法。---- customByProxyMethod");
    }

}
