package com.liu.study.spring.bean.definition;

import com.liu.study.spring.xiaomage.first.dependency.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * Bean Definition构建的示例。
 *
 * @author Liuweian
 * @createTime 2020/12/26 15:16
 * @version 1.0.0
 */
public class BeanDefinitionCreationDemo {

    public static void main(String[] args) {


    }

    /**
     * 通过BeanDefinitionBuilder创建。
     */
    private static void createBeanByBeanDefinitionBuilder() {
        /**
         * 通过BeanDefinitionBuilder的静态方法构建BeanDefinitionBuilder。
         * TODO: 学习genericBeanDefinition()和rootBeanDefinition()的区别。
         */
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);

        /**
         * 设置属性。
         */
        beanDefinitionBuilder.addPropertyValue("username", "Bean Definition Builder set Properties。");
        beanDefinitionBuilder.addPropertyValue("id", 100);

        /**
         * 获取Bean Definition对象，获取的BeanDefinition对象，并不是终态，还是可以对对象进行修改。
         */
        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
    }

    /**
     * 通过AbstractBeanDefinition及其派生类进行创建。
     */
    private static void createBeanByBeanAbstractBeanDefinition() {
        /**
         * 创建GenericBeanDefinition
         */
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();

        /**
         * 设置属性
         */
        genericBeanDefinition.setBeanClass(User.class);
        MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
        mutablePropertyValues.add("username", "Bean Definition Builder set Properties。 【Abstract Bean Definition】");
        genericBeanDefinition.setPropertyValues(mutablePropertyValues);
    }

}
