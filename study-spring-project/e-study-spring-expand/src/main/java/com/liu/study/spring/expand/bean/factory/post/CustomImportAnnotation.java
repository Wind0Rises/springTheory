package com.liu.study.spring.expand.bean.factory.post;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/9/27 11:40
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(CustomImportBeanDefinitionRegistrar.class)
public @interface CustomImportAnnotation {

    String scan();

}