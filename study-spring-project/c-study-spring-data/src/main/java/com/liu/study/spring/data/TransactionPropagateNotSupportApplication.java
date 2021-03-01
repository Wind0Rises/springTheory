package com.liu.study.spring.data;

import com.liu.study.spring.data.transaction.propagate.IAnnotationTransactionPropagateNotSupportService;
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
public class TransactionPropagateNotSupportApplication {

    /**
     * 以非事务方式执行，如果当前存在事务则将当前事务挂起。
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
        IAnnotationTransactionPropagateNotSupportService annotationTransactionPropagateService = applicationContext.getBean(IAnnotationTransactionPropagateNotSupportService.class);

        /**
         * 都会插入成功，A、B都没有事务。
         */
        annotationTransactionPropagateService.openTransaction(1);
    }

    /**
     *
     */
    public static void propagateLevelIsRequiredTestSecond() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/annotation-application-context.xml");
        IAnnotationTransactionPropagateNotSupportService annotationTransactionPropagateService = applicationContext.getBean(IAnnotationTransactionPropagateNotSupportService.class);

        annotationTransactionPropagateService.secondWayIsAHaveTransaction();
    }

    /**
     * Support不会创建事务，所有，所以只要调用这个方没有事务，所有方法都不会有事务。
     * 所以都会插入进去。
     */
    public static void propagateLevelIsRequiredTestThree() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/annotation-application-context.xml");
        IAnnotationTransactionPropagateNotSupportService annotationTransactionPropagateService = applicationContext.getBean(IAnnotationTransactionPropagateNotSupportService.class);
        annotationTransactionPropagateService.threeWayIsAHaveTransaction();
    }

}
