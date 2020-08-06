package com.liu.study.spring.mvc.config.test;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/8/6 11:45
 */
public class DeferredImportSelectorTest implements DeferredImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::");
        return new String[0];
    }
}