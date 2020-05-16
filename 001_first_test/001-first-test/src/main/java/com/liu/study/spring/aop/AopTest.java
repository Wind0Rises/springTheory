package com.liu.study.spring.aop;

import com.liu.study.spring.xml.CustomBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.TimeUnit;

/**
 * @desc 
 * @author Liuweian
 * @createTime 2020/5/15 21:21
 * @version 1.0.0
 */
public class AopTest {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-context.xml");
        PointCut pointCut = (PointCut) context.getBean("pointCut");
        System.out.println(pointCut.getClass());

        pointCut.aopTestMethod();
        TimeUnit.SECONDS.sleep(1000);
    }

}
