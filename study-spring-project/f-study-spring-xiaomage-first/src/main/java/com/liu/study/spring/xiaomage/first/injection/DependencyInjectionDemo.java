package com.liu.study.spring.xiaomage.first.injection;

import com.liu.study.spring.xiaomage.first.dependency.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

/**
 * <note>
 *     依赖注入示例。
 * </note>
 * 
 * @author Liuweian
 * @createTime 2020/12/20 19:19
 * @version 1.0.0
 */
public class DependencyInjectionDemo {

    public static void main(String[] args) {

        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");

        UserRepository userRepository = beanFactory.getBean(UserRepository.class);
        // System.out.println(bean.getUsers());

        System.out.println(userRepository.getBeanFactory() == beanFactory);

        ObjectFactory userObjectFactory = userRepository.getUserObjectFactory();
        System.out.println(userObjectFactory.getObject());
        System.out.println(userObjectFactory.getObject() == beanFactory);


        /**
         * 内建非Bean对象。
         */
        // beanFactory.getBean(BeanFactory.class);

        Environment environment = beanFactory.getBean(Environment.class);
        System.out.println("获取的Environ对象：" + environment);
    }


    /**
     * 谁才是IoC容器
     *
     * ApplicationContext is BeanFactory。
     *
     * BeanFactory接口提供了高级的配置的机制，能够管理这些<note>对象</note>。
     * ApplicationContext是BeanFactory的子接口：
     *          1、简化了和Spring Aop的整合。
     *          2、消息和资源的处理。
     *          3、事件的发布。
     *          4、应用级别的Context，例如WebApplicationContext
     *          5、配置的元信息（Configuration Metadata）
     *          6、国际化（i18n）
     *          7、注解（Annotations）  -->
     *          8、资源管理（Resources）
     *          9、Environment抽象
     *
     * BeanFactory是一个框架，是一个基本的IoC框架。
     * ApplicationContext则提供一个企业级IoC框架
     *
     * @param userRepository
     * @param beanFactory
     */
    private static void whoIsIoCContainer(UserRepository userRepository, BeanFactory beanFactory) {
        System.out.println(userRepository.getBeanFactory() == beanFactory);
    }

}
