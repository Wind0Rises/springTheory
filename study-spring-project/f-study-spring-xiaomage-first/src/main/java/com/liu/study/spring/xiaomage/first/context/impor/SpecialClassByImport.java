package com.liu.study.spring.xiaomage.first.context.impor;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

/**
 * 请看{@link com.liu.study.spring.xiaomage.first.context.AnnotationApplicationContextTest}@Import注解
 *
 * @author lwa
 * @version 1.0.0
 * @createTime 2021/2/1 14:53
 */
public class SpecialClassByImport {

    public String getImport() {
        return "test import";
    }

    @Getter
    @Setter
    @Value("${test.couponCode}")
    private String couponCode;

}
