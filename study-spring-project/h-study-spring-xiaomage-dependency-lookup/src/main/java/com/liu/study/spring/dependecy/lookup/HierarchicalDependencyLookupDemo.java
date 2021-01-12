package com.liu.study.spring.dependecy.lookup;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 *
 * @author Liuweian
 * @createTime 2020/12/26 22:00
 * @version 1.0.0
 */
public class HierarchicalDependencyLookupDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(HierarchicalDependencyLookupDemo.class);

        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
        System.out.println("当前Bean Factory的 Parent Factory：" + beanFactory.getParentBeanFactory());

        beanFactory.setParentBeanFactory(createBeanFactory());
        System.out.println("当前Bean Factory的 Parent Factory：" + beanFactory.getParentBeanFactory());

        applicationContext.refresh();
        applicationContext.close();
    }

    public static BeanFactory createBeanFactory() {
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        String classpath = "classpath:/META-INF/dependency-lookup-context.xml";
        xmlBeanDefinitionReader.loadBeanDefinitions(classpath);
        return defaultListableBeanFactory;
    }

}
