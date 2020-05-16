package com.liu.study.spring.xml;

/**
 * @desc 自定义Bean
 * @author Liuweian
 * @createTime 2020/5/9 21:36
 * @version 1.0.0
 */
public class CustomBean {

    private String name;

    public CustomBean() {
        System.out.println("CustomBean---customBeanMethod()--无参构造函数。");
    }

    public void customBeanMethod() {
        System.out.println("CustomBean---customBeanMethod()方法被调用！！！！！");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
