package com.liu.study.spring.expand.bean.factory.post;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

/**
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/9/27 10:17
 */
public class CustomImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     * 应该想Spring注入一个用户解析的Mapper的类。
     * {@link CustomImportAnnotation}注解应该有一个用于确定范围属性。
     *
     * @param importingClassMetadata
     * @param registry
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        Map<String, Object> annotationAttributes = importingClassMetadata.getAnnotationAttributes(CustomImportAnnotation.class.getName());
        String scan = (String) annotationAttributes.get("scan");
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(CustomBeanDefinitionRegistryPostProcessor.class);
        beanDefinitionBuilder.addConstructorArgValue(scan);
        registry.registerBeanDefinition("customBeanDefinitionRegistryPostProcessor",
                beanDefinitionBuilder.getBeanDefinition());
    }
}