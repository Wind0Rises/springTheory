package com.liu.study.spring.mvc.config.test;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/8/6 10:40
 */
public class ImportSelectorTest implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        System.out.println("----------------------------------------------------");
        return new String[]{"com.liu.study.spring.mvc.config.test.ImportSelectorClass"};
    }
}