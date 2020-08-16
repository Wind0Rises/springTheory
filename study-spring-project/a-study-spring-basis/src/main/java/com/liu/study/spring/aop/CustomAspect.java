package com.liu.study.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @desc
 * @author Liuweian
 * @createTime 2020/5/15 21:08
 * @version 1.0.0
 */
public class CustomAspect {
    public void before(JoinPoint point) {
        System.out.println("CustomAspect ---  前置处理");
        System.out.println(point.getClass());
    }

    public void after() {
        System.out.println("CustomAspect ---  后置处理");
    }

    public void afterReturn() {
        System.out.println("CustomAspect ---  返回_____处理");
    }

    public void afterThrow() {
        System.out.println("CustomAspect ---  异常_____处理");
    }

    public void around(ProceedingJoinPoint point) throws Throwable {
        System.out.println("CustomAspect ---  环绕处理1");
        point.proceed();
        System.out.println(point.getClass());
        System.out.println("CustomAspect ---  环绕处理2");
    }
}
