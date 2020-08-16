package com.liu.study.spring.mvc.config;

import com.liu.study.spring.mvc.config.test.ImportBeanDefinitionRegistrarTest;
import com.liu.study.spring.mvc.config.test.ImportClass;
import com.liu.study.spring.mvc.config.test.ImportSelectorTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * @Import注解的使用，已经ImportSelector、ImportBeanDefinitionRegisterar
 *
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/8/6 9:54
 */
@Import({ImportClass.class, ImportBeanDefinitionRegistrarTest.class, ImportSelectorTest.class})
@Configuration
public class ImportTest {
}