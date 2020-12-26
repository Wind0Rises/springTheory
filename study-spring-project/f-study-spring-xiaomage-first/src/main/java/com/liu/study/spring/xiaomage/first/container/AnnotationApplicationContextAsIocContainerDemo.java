package com.liu.study.spring.xiaomage.first.container;

import com.liu.study.spring.xiaomage.first.dependency.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * {@link BeanFactory} 作为 IoC 容器实例
 *
 * @author Liuweian
 * @createTime 2020/12/24 22:02
 * @version 1.0.0
 */
@Configuration
public class AnnotationApplicationContextAsIocContainerDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 将当前类AnnotationApplicationContextAsIocContainerDemo作为配置类（Configuration Class）
        applicationContext.register(AnnotationApplicationContextAsIocContainerDemo.class);

        // 刷新操作。
        applicationContext.refresh();

        lookupCollect(applicationContext);
    }

    @Bean
    public User user() {
        User user = new User();
        user.setId(1100L);
        user.setUsername("AnnotationApplicationContext");
        return user;
    }

    /**
     * 查询多个。
     * @param beanFactory
     */
    private static void lookupCollect(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> beansOfType = listableBeanFactory.getBeansOfType(User.class);
            System.out.println(beansOfType);
        }
    }

}
