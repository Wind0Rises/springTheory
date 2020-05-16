package com.liu.study.spring.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @desc 
 * @author Liuweian
 * @createTime 2020/5/9 21:35
 * @version 1.0.0
 */
public class XmlTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-context.xml");
        CustomBean customBean = (CustomBean) context.getBean("customBean");



        customBean.customBeanMethod();
    }

}
