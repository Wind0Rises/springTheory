package com.liu.study.spring.expand.bean.factory.post;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/9/27 11:30
 */
@ComponentScan("com.liu.study.spring.expand.bean.factory.*")
@CustomImportAnnotation(scan = "com.liu.study.spring.expand.bean.factory.post.*")
public class BeanFactoryPostProcessConfig {

    @Bean
    public CustomImportBeanDefinitionRegistrar customImportBeanDefinitionRegistrar() {
        System.out.println("this is CustomConfig#customImportBeanDefinitionRegistrar");
        return new CustomImportBeanDefinitionRegistrar();
    }

}