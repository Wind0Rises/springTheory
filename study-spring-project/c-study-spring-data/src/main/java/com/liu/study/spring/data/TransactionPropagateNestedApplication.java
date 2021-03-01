package com.liu.study.spring.data;

import com.liu.study.spring.data.transaction.propagate.IAnnotationTransactionPropagateNestedService;
import com.liu.study.spring.data.transaction.propagate.IAnnotationTransactionPropagateNotSupportService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring的事务传播特性试验：
 *
 * TODO：未理解
 *
 *
 * @author lwa
 * @version 1.0.0
 * @createTime 2021/2/26 13:01
 */
public class TransactionPropagateNestedApplication {

    /**
     * 如果当前存在事务，则在嵌套事务内执行。
     * 如果当前没有事务，则进行与PROPAGATION_REQUIRED类似的操作。
     *
     * TODO：不理解。
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
        // propagateLevelIsRequiredTestThree();
    }

    /**
     *
     */
    public static void propagateLevelIsRequiredTestFirst() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/annotation-application-context.xml");
        IAnnotationTransactionPropagateNestedService annotationTransactionPropagateService = applicationContext.getBean(IAnnotationTransactionPropagateNestedService.class);

        annotationTransactionPropagateService.firstWayIsAHaveTransaction();;
    }

    /**
     *
     *
     *
     *
     *
     *
     */
    public static void propagateLevelIsRequiredTestSecond() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/annotation-application-context.xml");
        IAnnotationTransactionPropagateNestedService annotationTransactionPropagateService = applicationContext.getBean(IAnnotationTransactionPropagateNestedService.class);

        // 02、以非事务开始。
        annotationTransactionPropagateService.secondWayIsAHaveTransaction();
    }

    /**
     *
     */
    public static void propagateLevelIsRequiredTestThree() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/annotation-application-context.xml");
        IAnnotationTransactionPropagateNestedService annotationTransactionPropagateService = applicationContext.getBean(IAnnotationTransactionPropagateNestedService.class);
        annotationTransactionPropagateService.threeWayIsAHaveTransaction();
    }

}
