package com.liu.study.spring.defination;

import com.liu.study.spring.defination.bean.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * 定义Bean的元信息：
 *      1、通过BeanDefinitionBuilder
 *      2、通过AbstractBeanDefinition的派生类。
 *
 * @author Liuweian
 * @createTime 2020/8/16 22:17
 * @version 1.0.0
 */
public class BeanDefinitionCreateDemo {

    public static void main(String[] args) {
        /**
         * 通过BeanDefinitionBuilder创建BeanDefinition.
         */
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);

        beanDefinitionBuilder.addPropertyValue("username", "liuweian");
        beanDefinitionBuilder.addPropertyValue("ange", "23");


        BeanDefinition userBeanDefinition = beanDefinitionBuilder.getBeanDefinition();


        /**
         * 02、使用AbstractBeanDefinition构建BeanDefinition。
         * 02、使用AbstractBeanDefinition构建BeanDefinition。
         */
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(User.class);
        MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
        mutablePropertyValues.addPropertyValue("username", "liuweian");
        mutablePropertyValues.addPropertyValue("ange", "23");
        beanDefinition.setPropertyValues(mutablePropertyValues);

    }

}
