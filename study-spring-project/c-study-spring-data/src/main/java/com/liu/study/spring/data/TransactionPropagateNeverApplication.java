package com.liu.study.spring.data;

import com.liu.study.spring.data.transaction.propagate.IAnnotationTransactionPropagateNeverService;
import com.liu.study.spring.data.transaction.propagate.IAnnotationTransactionPropagateNotSupportService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring的事务传播特性试验：
 *
 *
 * @author lwa
 * @version 1.0.0
 * @createTime 2021/2/26 13:01
 */
public class TransactionPropagateNeverApplication {

    /**
     * 以非事务方式进行，如果存在事务则抛出异常
     */
    public static void main(String[] args) throws Exception {
        /**
         *
         */
        // propagateLevelIsRequiredTestFirst();

        /**
         *
         */
        propagateLevelIsRequiredTestSecond();

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
        IAnnotationTransactionPropagateNeverService annotationTransactionPropagateService = applicationContext.getBean(IAnnotationTransactionPropagateNeverService.class);

        /**
         * 抛出异常：
         * IllegalTransactionStateException: Existing transaction found for transaction marked with propagation 'never'
         */
        annotationTransactionPropagateService.openTransaction(1);
    }

    /**
     *
     */
    public static void propagateLevelIsRequiredTestSecond() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/annotation-application-context.xml");
        IAnnotationTransactionPropagateNeverService annotationTransactionPropagateService = applicationContext.getBean(IAnnotationTransactionPropagateNeverService.class);

        /**
         * 抛出异常：
         * IllegalTransactionStateException: Existing transaction found for transaction marked with propagation 'never'
         */
        annotationTransactionPropagateService.openTransaction(2);
    }



    /**
     *
     */
    public static void propagateLevelIsRequiredTestThree() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/annotation-application-context.xml");
        IAnnotationTransactionPropagateNeverService annotationTransactionPropagateService = applicationContext.getBean(IAnnotationTransactionPropagateNeverService.class);
        /**
         *
         */
        annotationTransactionPropagateService.threeWayIsAHaveTransaction();
    }

}
