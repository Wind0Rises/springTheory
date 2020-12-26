package com.liu.study.spring.bean.definition;

import com.liu.study.spring.bean.definition.model.Student;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean的创建过程  特殊的方法。
 *
 * @author Liuweian
 * @createTime 2020/12/26 20:47
 * @version 1.0.0
 */
public class SpecificBeanInstantiationDemo {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-instantiation-context.xml");


    }

}
