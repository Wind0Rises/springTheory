package com.liu.study.spring.expand.bean.factory.post;

import com.liu.study.spring.expand.bean.factory.post.apply.CustomMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 *
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/9/27 10:01
 */
public class BeanFactoryPostProcessTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanFactoryPostProcessConfig.class);
        CustomMapper bean = applicationContext.getBean(CustomMapper.class);
        bean.mapper();
    }

}