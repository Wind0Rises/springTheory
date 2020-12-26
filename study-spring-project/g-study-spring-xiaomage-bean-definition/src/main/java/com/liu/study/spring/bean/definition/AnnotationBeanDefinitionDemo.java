package com.liu.study.spring.bean.definition;

import com.liu.study.spring.xiaomage.first.dependency.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * 
 * @author Liuweian
 * @createTime 2020/12/26 18:20
 * @version 1.0.0
 */
@Import(AnnotationBeanDefinitionDemo.Config.class)
public class AnnotationBeanDefinitionDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(AnnotationBeanDefinitionDemo.class);


        registerUserBeanDefinition(applicationContext, "llllllllllllllllll");
        registerUserBeanDefinition(applicationContext);


        applicationContext.refresh();

        System.out.println(applicationContext.getBeansOfType(Config.class));
        System.out.println(applicationContext.getBeansOfType(User.class));

        applicationContext.close();
    }

    /**
     * 注册User到BeanDefinitionRegistry。
     *
     * @param registry
     * @param beanName
     */
    public static void registerUserBeanDefinition(BeanDefinitionRegistry registry, String beanName) {
        /**
         * 第一步：创建一个BeanDefinitionBuilder
         */
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);

        /**
         * 第二步：设置属性
         */
        beanDefinitionBuilder.addPropertyValue("username", "刘维bbbbb安")
                .addPropertyValue("id", 100L);

        /**
         * 第三步：把BeanDefinition注册到BeanDefinitionRegistry中。
         */
        if (StringUtils.hasText(beanName)) {
            registry.registerBeanDefinition(beanName, beanDefinitionBuilder.getBeanDefinition());
        } else {
            BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(), registry);
        }
    }

    public static void registerUserBeanDefinition(BeanDefinitionRegistry registry) {
        registerUserBeanDefinition(registry, null);
    }

    @Component
    public static class Config {

        @Bean(name = {"liuweian", "sssuser"})
        public User getUser() {
            User user = new User();
            user.setUsername("Annotation Bean Definition");
            return user;
        }
    }
}
