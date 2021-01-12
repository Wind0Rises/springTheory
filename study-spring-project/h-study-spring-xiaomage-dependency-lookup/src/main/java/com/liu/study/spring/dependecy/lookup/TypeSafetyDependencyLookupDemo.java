package com.liu.study.spring.dependecy.lookup;

import com.liu.study.spring.xiaomage.first.dependency.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

/**
 * 
 * @author Liuweian
 * @createTime 2021/1/11 20:27
 * @version 1.0.0
 */
public class TypeSafetyDependencyLookupDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(ObjectProviderDemo.class);
        applicationContext.refresh();

        // BeanFactory#getBean  方法安全性。【不安全的，会报错】
        displayBeanFactoryGetBean(applicationContext);

        // ObjectFactory#getObject 方法安全性。【不安全的，会报错】
        displayObjectFactoryGetObject(applicationContext);

        // ObjectProvider#getIfAvailable 方法安全性。【安全的】
        displayObjectProviderGetIfAvailable(applicationContext);

        System.out.println("========================  集合类型  ==========================");
        // ListableBeanFactory#getBeansOfTyps 方法安全性。【安全的】
        displayListableBeanFactoryGetBeansOfType(applicationContext);
        // ObjectProvider#forEach 方法安全性。【安全的】
        displayObjectProviderOfStream(applicationContext);

        applicationContext.close();
    }

    /**
     * ObjectProvider#forEach 【不会报错】
     * @param beanFactory
     */
    private static void displayObjectProviderOfStream(BeanFactory beanFactory) {
        ObjectProvider<User> objectProvider = beanFactory.getBeanProvider(User.class);
        printException("displayObjectProviderOfStream",  () -> objectProvider.forEach(System.out::println));
    }

    /**
     * ListableBeanFactory#getBeansOfTyps 【不会报错】
     * @param applicationContext
     */
    private static void displayListableBeanFactoryGetBeansOfType(ListableBeanFactory applicationContext) {
        printException("displayListableBeanFactoryGetBeansOfType",  () -> applicationContext.getBeansOfType(User.class));
    }

    /**
     * ObjectProvider#getIfAvailable 安全的
     * @param applicationContext
     */
    private static void displayObjectProviderGetIfAvailable(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<User> objectProvider = applicationContext.getBeanProvider(User.class);
        printException("displayObjectProviderGetIfAvailable",  () -> objectProvider.getIfAvailable());
    }

    /**
     * ObjectFactory#getObject 是不安全的。
     * @param beanFactory
     */
    public static void displayObjectFactoryGetObject(BeanFactory beanFactory) {
        ObjectFactory<User> objectFactory = beanFactory.getBeanProvider(User.class);
        printException("displayObjectFactoryGetObject",  () -> objectFactory.getObject());
    }

    /**
     * BeanFactory#getBean是不安全的。
     *
     * @param beanFactory
     */
    public static void displayBeanFactoryGetBean(BeanFactory beanFactory) {
        printException("displayBeanFactoryGetBean",  () -> beanFactory.getBean(User.class));
    }

    /**
     * 打印异常。
     *
     * @param source
     * @param runnable
     */
    public static void printException(String source, Runnable runnable) {
        System.err.println("来源为：" + source);
        try {
            runnable.run();
        } catch (BeansException exception) {
            exception.printStackTrace();
        }
    }
}
