package com.liu.study.spring.data;

import com.liu.study.spring.data.transaction.propagate.IAnnotationTransactionPropagateMandatoryService;
import com.liu.study.spring.data.transaction.propagate.IAnnotationTransactionPropagateRequiredNewService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring的事务传播特性试验：
 *
 *
 * @author lwa
 * @version 1.0.0
 * @createTime 2021/2/26 13:01
 */
public class TransactionPropagateRequiredNewApplication {

    /**
     * 创建一个新的事务并挂起当前事务
     * 如果当前存在事务，则挂起事务，创建新的事务，
     * 如果当前没有事务，支持当前事务。
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
         propagateLevelIsRequiredTestThree();
    }

    /**
     *
     */
    public static void propagateLevelIsRequiredTestFirst() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/annotation-application-context.xml");
        IAnnotationTransactionPropagateRequiredNewService annotationTransactionPropagateService = applicationContext.getBean(IAnnotationTransactionPropagateRequiredNewService.class);

        /**
         * 都不会插入成功；
         * firstWayIsAHaveTransaction、firstWayIsBNoHaveTransaction使用的是同一个事务。
         */
        annotationTransactionPropagateService.firstWayIsAHaveTransaction();
    }

    /**
     *
     */
    public static void propagateLevelIsRequiredTestSecond() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/annotation-application-context.xml");
        IAnnotationTransactionPropagateRequiredNewService annotationTransactionPropagateService = applicationContext.getBean(IAnnotationTransactionPropagateRequiredNewService.class);

        /**
         * way_2: B have transaction将插入成功，使用的是自己的事务。
         */
        annotationTransactionPropagateService.secondWayIsAHaveTransaction();
    }

    /**
     * A没有事务，会插入数据库；
     * B有事务，但是没有异常，会插入数据库。
     */
    public static void propagateLevelIsRequiredTestThree() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/annotation-application-context.xml");
        IAnnotationTransactionPropagateRequiredNewService annotationTransactionPropagateService = applicationContext.getBean(IAnnotationTransactionPropagateRequiredNewService.class);
        annotationTransactionPropagateService.threeWayIsAHaveTransaction();
    }

}
