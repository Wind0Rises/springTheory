package com.liu.study.spring.data;

import com.liu.study.spring.data.transaction.propagate.IAnnotationTransactionPropagateMandatoryService;
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
public class TransactionPropagateMandatoryApplication {

    /**
     * 如果当前有事务，则支持当前事务，
     * 如果当前没有事务，直接报错
     * <note>不会创建新的事务</note>
     */
    public static void main(String[] args) throws Exception {
        /**
         *
         */
        propagateLevelIsRequiredTestFirst();

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
     */
    public static void propagateLevelIsRequiredTestFirst() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/annotation-application-context.xml");
        IAnnotationTransactionPropagateMandatoryService annotationTransactionPropagateService = applicationContext.getBean(IAnnotationTransactionPropagateMandatoryService.class);

        // 01、以事务执行，不会以事务执行，任务数据都不会插入。
        // annotationTransactionPropagateService.openTransaction(1);

        // 02、以无事务执行
        // 抛出异常：[IllegalTransactionStateException：No existing transaction found for transaction marked with propagation 'mandatory']
        annotationTransactionPropagateService.firstWayIsAHaveTransaction();
    }

    /**
     *
     */
    public static void propagateLevelIsRequiredTestSecond() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/annotation-application-context.xml");
        IAnnotationTransactionPropagateMandatoryService annotationTransactionPropagateService = applicationContext.getBean(IAnnotationTransactionPropagateMandatoryService.class);

        /**
         * 都会支持当前事务。如果调用secondWayIsAHaveTransaction()方法的方法存在事务，则支持这个事务
         * 如果没有事务，则以无事务执行。
         */

        // 01、有事务执行。不会插入数据。
        // annotationTransactionPropagateService.openTransaction(2);

        // 02、无事务执行。会插入数据，并且都插入。
        // 抛出异常：[IllegalTransactionStateException：No existing transaction found for transaction marked with propagation 'mandatory']
        annotationTransactionPropagateService.secondWayIsAHaveTransaction();
    }

    /**
     * Support不会创建事务，所有，所以只要调用这个方没有事务，所有方法都不会有事务。
     * 所以都会插入进去。
     */
    public static void propagateLevelIsRequiredTestThree() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/annotation-application-context.xml");
        IAnnotationTransactionPropagateMandatoryService annotationTransactionPropagateService = applicationContext.getBean(IAnnotationTransactionPropagateMandatoryService.class);
        annotationTransactionPropagateService.threeWayIsAHaveTransaction();
    }

}
