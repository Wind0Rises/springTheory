package com.liu.study.spring.expand.bean.factory.post.apply;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Proxy;

/**
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/9/27 13:15
 */
public class CustomFactoryBean implements FactoryBean {

    private Class clazz;

    public CustomFactoryBean(Class clazz) {
        this.clazz = clazz;
    }

    @Override
    public Object getObject() throws Exception {
        Class[] clazzes = new Class[]{this.clazz};
        Object proxy = Proxy.newProxyInstance(this.getClass().getClassLoader(), clazzes, new CustomMapperInvocationHandler());
        return proxy;
    }

    @Override
    public Class<?> getObjectType() {
        return this.clazz;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}