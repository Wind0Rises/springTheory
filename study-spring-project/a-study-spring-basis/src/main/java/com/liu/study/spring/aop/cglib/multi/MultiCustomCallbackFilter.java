package com.liu.study.spring.aop.cglib.multi;

import net.sf.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

/**
 * @author Liuweian
 * @version 1.0.0
 * @desc
 * @createTime 2020/5/20 16:04
 */
public class MultiCustomCallbackFilter implements CallbackFilter {

    @Override
    public int accept(Method method) {
        return 1;
    }

}
