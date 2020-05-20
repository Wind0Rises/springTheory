package com.liu.study.spring.aop.cglib;

import com.liu.study.spring.aop.cglib.chain.*;
import com.liu.study.spring.aop.cglib.multi.MultiCustomCallbackFilter;
import com.liu.study.spring.aop.cglib.multi.MultiFirstInterceptor;
import com.liu.study.spring.aop.cglib.multi.MultiSecondInterceptor;
import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Liuweian
 * @version 1.0.0
 * @desc
 * @createTime 2020/5/20 14:02
 */
public class CglibTest {

    /**
     * Enhancer [ɪnˈhænsər]：增强剂。
     */
    public static void main(String[] args) {
        // singletonCallbackTest();

        // multiCallbackTest();

        /**
         * 这个Aop的原理类似。
         */
        chainCallbackTest();
    }

    /**
     * Cglib会生成三个文件。
     *      1、EnhancerByCGLIB：这个继承了被代理类、实现net.sf.cglib.proxy.Factory接口。
     *      2、EnhancerByCGLIB$$FastClassByCGLIB：继承了net.sf.cglib.reflect.FastClass
     *      3、FastClassByCGLIB：继承了net.sf.cglib.reflect.FastClass;
     */
    public static void singletonCallbackTest() {

        // 代理类class文件存入本地磁盘方便我们反编译查看源码
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\tmp\\test\\singleton");

        // 通过CGLIB动态代理获取代理对象的过程
        Enhancer enhancer = new Enhancer();

        // 设置enhancer对象的父类
        enhancer.setSuperclass(CustomByProxyClass.class);

        // 设置enhancer的回调对象
        enhancer.setCallback(new SingletonInterceptor());

        // 创建代理对象
        CustomByProxyClass proxy= (CustomByProxyClass) enhancer.create();

        // 打印类名。
        System.out.println(proxy.getClass());

        // 通过代理对象调用目标方法
        proxy.customByProxyMethod();
    }

    public static void multiCallbackTest() {
        // 代理类class文件存入本地磁盘方便我们反编译查看源码
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\tmp\\test\\multi");

        // 通过CGLIB动态代理获取代理对象的过程
        Enhancer enhancer = new Enhancer();

        // 设置enhancer对象的父类
        enhancer.setSuperclass(CustomByProxyClass.class);

        // 设置enhancer的回调对象

        enhancer.setCallbacks(new Callback[]{ new MultiFirstInterceptor(), new MultiSecondInterceptor() });
        enhancer.setCallbackFilter(new MultiCustomCallbackFilter());

        // 创建代理对象
        CustomByProxyClass proxy= (CustomByProxyClass) enhancer.create();

        // 打印类名。
        System.out.println(proxy.getClass());

        // 通过代理对象调用目标方法
        proxy.customByProxyMethod();
    }

    public static void chainCallbackTest() {
        // 代理类class文件存入本地磁盘方便我们反编译查看源码
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\tmp\\test\\chain");

        // 通过CGLIB动态代理获取代理对象的过程
        Enhancer enhancer = new Enhancer();

        // 设置enhancer对象的父类
        enhancer.setSuperclass(CustomByProxyClass.class);

        // 设置enhancer的回调对象
        List<AdvisorService> advisorServices = new ArrayList<>(2);
        advisorServices.add(new CustomFirstAdvisorServiceImpl());
        advisorServices.add(new CustomSecondAdvisorServiceImpl());
        AdvisorChain advisorChain = new AdvisorChain(advisorServices);
        ChainMethodInterceptor chainMethodInterceptor = new ChainMethodInterceptor(advisorChain);
        enhancer.setCallback(chainMethodInterceptor);

        // 创建代理对象
        CustomByProxyClass proxy= (CustomByProxyClass) enhancer.create();

        // 打印类名。
        System.out.println(proxy.getClass());

        // 通过代理对象调用目标方法
        proxy.customByProxyMethod();
    }

}
