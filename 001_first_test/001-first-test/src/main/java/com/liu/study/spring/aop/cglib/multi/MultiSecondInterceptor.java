package com.liu.study.spring.aop.cglib.multi;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @desc 自定义方法拦截器
 * @author Liuweian
 * @version 1.0.0
 * @createTime 2019/12/30 10:45
 */
public class MultiSecondInterceptor implements MethodInterceptor {

    /**
     *
     * @param sub obj表示增强的对象，即实现这个接口类的一个对象
     * @param method method表示要被拦截的方法
     * @param args args表示要被拦截方法的参数
     * @param proxy proxy表示要触发父类的方法对象
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object sub, Method method, Object[] args, MethodProxy proxy) throws Throwable {

        System.out.println("==============  第二个拦截器  开始  ===================");
        Object result = proxy.invokeSuper(sub, args);
        System.out.println("==============  第二个拦截器  结束  ===================");
        return result;
    }
}
