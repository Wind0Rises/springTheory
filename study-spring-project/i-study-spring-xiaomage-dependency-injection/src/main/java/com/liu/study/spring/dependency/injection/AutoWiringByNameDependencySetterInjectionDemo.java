package com.liu.study.spring.dependency.injection;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * "byName" Auto-Wiring
 * @author Liuweian
 * @createTime 2021/1/12 22:22
 * @version 1.0.0
 */
public class AutoWiringByNameDependencySetterInjectionDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);

        String resourcePath = "classpath:/META-INF/autowiring-dependency-setter-injection.xml";

        xmlBeanDefinitionReader.loadBeanDefinitions(resourcePath);

        UserHolder bean = beanFactory.getBean(UserHolder.class);
        System.out.println(bean.getUser());
    }

}
