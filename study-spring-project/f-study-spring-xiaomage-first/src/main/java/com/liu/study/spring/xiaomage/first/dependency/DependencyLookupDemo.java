package com.liu.study.spring.xiaomage.first.dependency;

import com.liu.study.spring.xiaomage.first.dependency.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 *
 * <note>
 *     Spring中的依赖查找Demo。
 * </note>
 *
 * @author Liuweian
 * @createTime 2020/12/19 16:51
 * @version 1.0.0
 */
public class DependencyLookupDemo {
    public static void main(String[] args) {

        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-lookup-context.xml");

        lookupInRealtime(beanFactory);

        lookupInLazy(beanFactory);

        lookupByType(beanFactory);

        lookupCollect(beanFactory);
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

    /**
     * 通过类型查找。
     * @param beanFactory
     */
    private static void lookupByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println(user);
    }

    /**
     * 实时查找。
     */
    private static void lookupInRealtime(BeanFactory beanFactory) {
        User user = (User) beanFactory.getBean("user");
        System.out.println(user);
    }

    /**
     * 延迟查找。
     */
    private static void lookupInLazy(BeanFactory beanFactory) {
        ObjectFactory<User> objectFactory = (ObjectFactory) beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();
        System.out.println(user);
    }

}
