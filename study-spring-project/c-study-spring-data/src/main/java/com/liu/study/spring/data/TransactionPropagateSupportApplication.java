package com.liu.study.spring.data;

import com.liu.study.spring.data.transaction.propagate.IAnnotationTransactionPropagateRequiredService;
import com.liu.study.spring.data.transaction.propagate.IAnnotationTransactionPropagateSupportService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring的事务传播特性试验：
 *
 *
 * @author lwa
 * @version 1.0.0
 * @createTime 2021/2/26 13:01
 */
public class TransactionPropagateSupportApplication {

    /**
     * 如果当前有事务，则支持当前事务，
     * 如果当前没有事务，则以无事务执行。
     */
    public static void main(String[] args) throws Exception {
        /**
         *
         */
        // propagateLevelIsRequiredTestFirst();

        /**
         *
         */
        // propagateLevelIsRequiredTestSecond();

        /**
         *
         */
        // propagateLevelIsRequiredTestThree();
    }

    /**
     *
     *
     */
    public static void propagateLevelIsRequiredTestFirst() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/annotation-application-context.xml");
        IAnnotationTransactionPropagateSupportService annotationTransactionPropagateService = applicationContext.getBean(IAnnotationTransactionPropagateSupportService.class);
        annotationTransactionPropagateService.firstWayIsAHaveTransaction();
    }

    /**
     *
     */
    public static void propagateLevelIsRequiredTestSecond() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/annotation-application-context.xml");
        IAnnotationTransactionPropagateSupportService annotationTransactionPropagateService = applicationContext.getBean(IAnnotationTransactionPropagateSupportService.class);
        annotationTransactionPropagateService.secondWayIsAHaveTransaction();
    }

    /**
     *
     */
    public static void propagateLevelIsRequiredTestThree() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/annotation-application-context.xml");
        IAnnotationTransactionPropagateSupportService annotationTransactionPropagateService = applicationContext.getBean(IAnnotationTransactionPropagateSupportService.class);
        annotationTransactionPropagateService.threeWayIsAHaveTransaction();
    }

}
