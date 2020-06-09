package com.liu.study.spring.aop.cglib.chain;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author Liuweian
 * @version 1.0.0
 * @desc
 * @createTime 2020/5/20 16:12
 */
public class ChainMethodInterceptor implements MethodInterceptor {

    private AdvisorChain advisorChain;

    public ChainMethodInterceptor(AdvisorChain advisorChain) {
        this.advisorChain = advisorChain;
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        return advisorChain.process();
    }

}
