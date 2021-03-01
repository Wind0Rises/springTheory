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
     * 如果当前有事务，则支持当前事务，
     * 如果当前没有事务，直接报错
     * <note>不会创建新的事务</note>
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

        // 02、以无事务执行
        annotationTransactionPropagateService.firstWayIsAHaveTransaction();
    }

    /**
     *
     */
    public static void propagateLevelIsRequiredTestSecond() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/annotation-application-context.xml");
        IAnnotationTransactionPropagateRequiredNewService annotationTransactionPropagateService = applicationContext.getBean(IAnnotationTransactionPropagateRequiredNewService.class);

        // 01、有事务执行。不会插入数据。
        // A方法会创建一个事务，B方法也会自己创建一个事务。A不会使用openTransaction()的事务，B不会使用A的事务。
        // A抛出异常，事务回滚；B正常执行，B执行完成以后会提交事务，B方法的数据会插入数据库。
        // annotationTransactionPropagateService.openTransaction(2);

        // 02、以无事务开始执行；
        // A方法会创建一个事务，B方法也会自己创建一个事务。
        // A抛出异常，事务回滚；B正常执行，B执行完成以后会提交事务，B方法的数据会插入数据库。
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
