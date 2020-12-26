package com.liu.study.spring.xiaomage.first.container;

import com.liu.study.spring.xiaomage.first.dependency.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * {@link BeanFactory} 作为 IoC 容器实例
 *
 * @author Liuweian
 * @createTime 2020/12/24 22:02
 * @version 1.0.0
 */
public class BeanFactoryAsIocContainerDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        String classpath = "classpath:/META-INF/dependency-lookup-context.xml";
        int number = xmlBeanDefinitionReader.loadBeanDefinitions(classpath);
        System.out.println(number);

        lookupCollect(defaultListableBeanFactory);
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
