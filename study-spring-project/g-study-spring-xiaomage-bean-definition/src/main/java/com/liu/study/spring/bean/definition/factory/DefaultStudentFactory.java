package com.liu.study.spring.bean.definition.factory;

import com.liu.study.spring.bean.definition.model.Student;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import javax.annotation.PostConstruct;

/**
 * 
 * @author Liuweian
 * @createTime 2020/12/26 20:50
 * @version 1.0.0
 */
public class DefaultStudentFactory implements StudentFactory, InitializingBean {

    public DefaultStudentFactory() {
        System.out.println("【DefaultStudentFactory】---无参构造函数。");
    }

    @PostConstruct
    public void initMethod() {
        System.out.println("【DefaultStudentFactory】---被@PostConstruct修饰的方法。");
    }

    public void customInitMethod() {
        System.out.println("【DefaultStudentFactory】---自定义初始化方法。");
    }


    @Override
    public Student crateStudent() {
        Student s = Student.builder()
                .username("student factory create student")
                .like("通过StudentFactory创建Student")
                .age(10).build();
        return s;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("【DefaultStudentFactory】---InitializingBean的afterPropertiesSet");
    }
}
