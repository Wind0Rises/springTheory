package com.liu.study.spring.bean.definition;

import com.liu.study.spring.bean.definition.model.Student;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean的创建过程  普通的方法。
 *
 * @author Liuweian
 * @createTime 2020/12/26 20:47
 * @version 1.0.0
 */
public class BeanInstantiationDemo {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-instantiation-context.xml");

        /**
         * 通过静态方法创建Bean
         */
        Student staticMethod = beanFactory.getBean("static-method-crate-student", Student.class);
        System.out.println(staticMethod);

        /**
         * 通过工厂方法创建的
         */
        Student studentFactory = beanFactory.getBean("crate-student-by-factory", Student.class);
        System.out.println(studentFactory);

        /**
         * 通过工厂方法创建的
         */
        Student factoryBean = beanFactory.getBean("student-bean-by-factory-bean", Student.class);
        System.out.println(factoryBean);
    }

}
