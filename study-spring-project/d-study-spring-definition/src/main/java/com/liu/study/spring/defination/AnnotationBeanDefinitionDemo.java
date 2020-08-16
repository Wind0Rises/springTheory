package com.liu.study.spring.defination;

import com.liu.study.spring.defination.bean.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

/**
 * 注解方式
 *
 * @author Liuweian
 * @version 1.0.0
 * @createTime 2020/8/16 22:57
 */
@Import(AnnotationBeanDefinitionDemo.Config.class)
public class AnnotationBeanDefinitionDemo {


    public static void main(String[] args) {
        System.out.println("##################");
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext();

        configApplicationContext.register(Config.class);

        configApplicationContext.refresh();

        System.out.println("user" + configApplicationContext.getBean("liuweian"));

        // 关闭Context
        configApplicationContext.close();

    }

    @Component
    public static class Config {
        @Bean("liuweian")
        public User user() {
            User user = new User("liuweian", 27);
            return user;
        }
    }


}
