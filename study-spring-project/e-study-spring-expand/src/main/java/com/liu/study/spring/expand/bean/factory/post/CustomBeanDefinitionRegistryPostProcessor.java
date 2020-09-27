package com.liu.study.spring.expand.bean.factory.post;

import com.liu.study.spring.expand.bean.factory.post.apply.CustomFactoryBean;
import com.liu.study.spring.expand.bean.factory.post.apply.CustomMapper;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * 自定义实现BeanDefinitionRegistryPostProcessor。
 * 用于加载{@link CustomMapper}的处理操作。
 *
 * postProcessBeanDefinitionRegistry先执行，postProcessBeanFactory后执行。
 *
 *
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/9/27 10:08
 */
public class CustomBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

    private String scan;

    public CustomBeanDefinitionRegistryPostProcessor(String scan) {
        this.scan = scan;
    }

    /**
     * 这是把BeanDefinition注册到Spring中。
     *
     * @param registry
     * @throws BeansException
     */
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        /**
         * 这里可以用于解析scan包下被@CustomMapperAnnotation注解修饰的类，把这些类注入到Spring中，
         * 这就是Mybatis的原理。
         *
         * {@link CustomMapper}
         */

        BeanDefinitionBuilder builder= BeanDefinitionBuilder.genericBeanDefinition(CustomMapper.class);
        GenericBeanDefinition beanDefinition = (GenericBeanDefinition) builder.getBeanDefinition();
        beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(beanDefinition.getBeanClassName());
        beanDefinition.setBeanClass(CustomFactoryBean.class);
        registry.registerBeanDefinition("customMapper", beanDefinition);
        System.out.println("postProcessBeanDefinitionRegistry");
    }

    /**
     * 改变BeanDefinition。
     *
     * @param beanFactory
     * @throws BeansException
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("postProcessBeanFactory");
    }

}