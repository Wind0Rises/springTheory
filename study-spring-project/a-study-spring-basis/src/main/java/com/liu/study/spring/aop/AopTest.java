package com.liu.study.spring.aop;

import com.liu.study.spring.aop.jdk.IOrderService;
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
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-aop.xml");
        PointCut pointCut = (PointCut) context.getBean("pointCut");

        System.out.println("\n#################### CGlib Proxy  ###############################\n");
        System.out.println(pointCut.getClass() + "\n");
        pointCut.aopTestMethod();


        /**
         * IOrderService、DecoratingProxy、SpringProxy、Advised
         */
        System.out.println("\n####################  JDK Proxy  ###############################\n");
        IOrderService orderService = (IOrderService) context.getBean("payOrderService");
        System.out.println(orderService.getClass() + "\n");
        orderService.getOrderMessage();


        TimeUnit.SECONDS.sleep(1000);
    }

}
