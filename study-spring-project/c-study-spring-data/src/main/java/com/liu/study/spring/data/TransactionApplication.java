package com.liu.study.spring.data;

import com.liu.study.spring.data.transaction.AnnotationTransactionService;
import com.liu.study.spring.data.transaction.StatementTransactionService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 事务学习；
 *
 * @author lwa
 * @version 1.0.0
 * @createTime 2021/2/25 13:18
 */
public class TransactionApplication {

    public static void main(String[] args) {

        /**
         * 声明式事务测试。
         * 声明式事务，需要在xml中配置对应的Advice和pointCut。
         */
        // statementTransactionTest();

        /**
         * 注解事务测试
         * 注解事务，需要在xml中开启<tx:annotation-driven />
         */
         annotationTransactionTest();

        /**
         * 事务测试。
         */
        // transactionTest();
    }

    /**
     * 声明式事务测试。
     *
     * {@link StatementTransactionService}类的所有update开头的方法都是有事务的。
     *
     */
    public static void statementTransactionTest() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/statement-application-context.xml");
        StatementTransactionService statementTransactionService = applicationContext.getBean(StatementTransactionService.class);

        // 没有事务
        try {
            statementTransactionService.noTransactionAddUserInfo();
        } catch (Exception e) {
            System.out.println("  No Transaction Exception");
        }

        // 有事务的
        try {
            statementTransactionService.haveTransactionAddUserInfo();
        } catch (Exception e) {
            System.out.println("  Transaction Exception");
        }
    }

    /**
     * 注解事务
     */
    public static void annotationTransactionTest() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/statement-application-context.xml");
        AnnotationTransactionService annotationTransactionService = applicationContext.getBean(AnnotationTransactionService.class);
        try {
            annotationTransactionService.noTransactionUpdateUserInfo();
        } catch (Exception e) {
            System.out.println("  No Transaction Exception");
        }


        try {
            annotationTransactionService.updateUserInfo();
        } catch (Exception e) {
            System.out.println("  Transaction Exception");
        }
    }



    public static void transactionTest() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/statement-application-context.xml");

        StatementTransactionService statementTransactionService = applicationContext.getBean(StatementTransactionService.class);

        statementTransactionService.updateUserInfoTest();
    }

}
