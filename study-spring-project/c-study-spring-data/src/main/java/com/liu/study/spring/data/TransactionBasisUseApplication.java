package com.liu.study.spring.data;

import com.liu.study.spring.data.transaction.AnnotationTransactionService;
import com.liu.study.spring.data.transaction.StatementTransactionService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 事务基础使用。
 *
 * @author lwa
 * @version 1.0.0
 * @createTime 2021/2/25 13:18
 */
public class TransactionBasisUseApplication {

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
         // annotationTransactionTest();

        /**
         *
         */
         innerMethodInvokeTransaction();
    }

    /**
     * 声明式事务测试。
     *
     * {@link StatementTransactionService}类的所有update开头的方法都是有事务的。
     *
     */
    public static void statementTransactionTest() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/annotation-application-context.xml");
        StatementTransactionService statementTransactionService = applicationContext.getBean(StatementTransactionService.class);

        // 没有事务
        try {
            statementTransactionService.noTransactionAddUserInfo();
        } catch (Exception e) {
            System.out.println("No Transaction Exception ----  如果statement_no_transaction插入成功，说明没有事务。");
        }

        // 有事务的
        try {
            statementTransactionService.haveTransactionAddUserInfo();
        } catch (Exception e) {
            System.out.println("  Transaction Exception  -----  如果statement_has_transaction插入不成功，说明事务起作用了。");
        }
    }

    /**
     * 注解事务
     */
    public static void annotationTransactionTest() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/annotation-application-context.xml");
        AnnotationTransactionService annotationTransactionService = applicationContext.getBean(AnnotationTransactionService.class);
        try {
            annotationTransactionService.noTransactionUpdateUserInfo();
        } catch (Exception e) {
            System.out.println("No Transaction throw Exception  ----  如果annotation_no_transaction插入成功，说明没有事务。");
        }


        try {
            annotationTransactionService.hasTransactionAddUserInfo();
        } catch (Exception e) {
            System.out.println("Transaction throw Exception   -----  如果annotation_has_transaction插入不成功，说明事务起作用了。");
        }
    }


    /**
     * 内部方法调用的事务情况。
     */
    private static void innerMethodInvokeTransaction() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/annotation-application-context.xml");
        AnnotationTransactionService annotationTransactionService = applicationContext.getBean(AnnotationTransactionService.class);

        try {
            annotationTransactionService.innerMethodInvokeTransaction();
        } catch (Exception e) {
            System.out.println("inner method invoke transaction  ----  如果inner_method_invoke_transaction插入成功，【说明内部调用事务是不起作用的】");
        }
    }
}
