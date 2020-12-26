package com.liu.study.spring.bean.definition;

import com.liu.study.spring.xiaomage.first.dependency.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author Liuweian
 * @createTime 2020/12/26 18:14
 * @version 1.0.0
 */
public class BeanAliasDemo {

    public static void main(String[] args) {

        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-definitions-context.xml");

        User liuweian = beanFactory.getBean("liuweian-user", User.class);
        User bean = beanFactory.getBean("user", User.class);
        System.out.println(liuweian == bean);
    }

}
