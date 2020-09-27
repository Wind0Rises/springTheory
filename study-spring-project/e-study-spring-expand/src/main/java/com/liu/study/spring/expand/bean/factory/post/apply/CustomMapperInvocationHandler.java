package com.liu.study.spring.expand.bean.factory.post.apply;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/9/27 11:45
 */
public class CustomMapperInvocationHandler implements InvocationHandler {

    private CustomMapperFirst target;

    public CustomMapperInvocationHandler() {

    }

    public CustomMapperInvocationHandler(CustomMapperFirst customMapperFirst) {
        this.target = customMapperFirst;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("--------------  开始  ---------------");
        System.out.println("###############    内部处理    ##############");
        System.out.println("--------------  结束  ---------------");
        return null;
    }
}