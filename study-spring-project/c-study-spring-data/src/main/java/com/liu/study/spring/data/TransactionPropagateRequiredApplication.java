package com.liu.study.spring.data;

import com.liu.study.spring.data.transaction.propagate.IAnnotationTransactionPropagateRequiredService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring的事务传播特性试验：
 *
 *
 * @author lwa
 * @version 1.0.0
 * @createTime 2021/2/26 13:01
 */
public class TransactionPropagateRequiredApplication {


    /**
     * 传播：肯定有多个方法的调用。
     *
     * 方法A；方法B
     *
     * 方式一：A有事务，B没有事务
     * 方式二：A有事务，B有事务
     * 方式三：A没有事务，B没有事务
     * 方式四：A没有事务，B有事务
     */


    /**
     * 如果当前有事务，则支持当前事务，
     * 如果当前没有事务，则创建一个事务。
     */
    public static void main(String[] args) throws Exception {
        /**
         * 方式一：A有事务，B没有事务
         *
         * 方法A、方法B使用的是同一个事务，所以不管A、B哪一个方法抛错，都会回滚所有的。
         *
         * <note>方法B没有事务，是使用方法A的事务。</note>
         */
        // propagateLevelIsRequiredTestFirst();

        /**
         * 方式二：A有事务，B有事务
         *
         * 方法A、方法B使用的是同一个事务，所以不管A、B哪一个方法抛错，都会回滚所有的。
         *
         * <note>方法B不会新起事务，会使用A的事务</note>
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
     *
     */
    public static void propagateLevelIsRequiredTestFirst() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/annotation-application-context.xml");
        IAnnotationTransactionPropagateRequiredService annotationTransactionPropagateService = applicationContext.getBean(IAnnotationTransactionPropagateRequiredService.class);
        annotationTransactionPropagateService.firstWayIsAHaveTransaction();
    }

    /**
     *
     */
    public static void propagateLevelIsRequiredTestSecond() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/annotation-application-context.xml");
        IAnnotationTransactionPropagateRequiredService annotationTransactionPropagateService = applicationContext.getBean(IAnnotationTransactionPropagateRequiredService.class);
        annotationTransactionPropagateService.secondWayIsAHaveTransaction();
    }

    /**
     *
     */
    public static void propagateLevelIsRequiredTestThree() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/annotation-application-context.xml");
        IAnnotationTransactionPropagateRequiredService annotationTransactionPropagateService = applicationContext.getBean(IAnnotationTransactionPropagateRequiredService.class);
        annotationTransactionPropagateService.threeWayIsAHaveTransaction();
    }

}
