package com.liu.study.spring.xiaomage.first.context.scan;

import org.springframework.stereotype.Service;

/**
 *
 * 请看{@link com.liu.study.spring.xiaomage.first.context.AnnotationApplicationContextTest}@ComponentScan注解。
 *
 * @author lwa
 * @version 1.0.0
 * @createTime 2021/2/1 14:00
 */
@Service
public class SpecialClassByComponentScan {

    public String getUsername() {
        return "liuweian";
    }

}
