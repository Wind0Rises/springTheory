package com.liu.study.spring.bean.definition.factory;

import com.liu.study.spring.bean.definition.model.Student;
import org.springframework.beans.factory.FactoryBean;

/**
 * 
 * @author Liuweian
 * @createTime 2020/12/26 20:59
 * @version 1.0.0
 */
public class StudentFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        Student factoryBean = Student.builder()
                .username("crate-student-by-factory")
                .like("通过FactoryBean创建Student")
                .age(23).build();
        return factoryBean;
    }

    @Override
    public Class<?> getObjectType() {
        return Student.class;
    }
}
