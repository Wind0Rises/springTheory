package com.liu.study.spring.data;

import com.liu.study.spring.data.model.User;
import com.liu.study.spring.data.service.IDataUserService;
import com.liu.study.spring.data.transaction.AnnotationTransactionService;
import com.liu.study.spring.data.transaction.StatementTransactionService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * @desc 
 * @author Liuweian
 * @createTime 2020/6/9 14:39
 * @version 1.0.0
 */
public class SpringDataApplication {

    public static void main(String[] args) {
        /**
         * spring-mybatis 操作数据库测试。
         */
        // firstMainTest();
        // updateUserTest();
        // addUserTest();

        /**
         * 声明式事务测试。
         * 声明式事务，需要在xml中配置对应的Advice和pointCut。
         */
        // statementTransactionTest();

        /**
         * 注解事务测试
         * 注解事务，需要在xml中开启<tx:annotation-driven />
         */
        //annotationTransactionTest();


        /**
         * 事务测试。
         */
        transactionTest();
    }

    public static void firstMainTest() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/application-context.xml");
        IDataUserService userService = applicationContext.getBean(IDataUserService.class);
        User user = userService.queryUserInfo(1);
        System.out.println("获取的用户信息为：" + user.toString());
    }

    public static void updateUserTest() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/application-context.xml");
        IDataUserService userService = applicationContext.getBean(IDataUserService.class);
        User user = userService.queryUserInfo(2);
        user.setUsername("阿的说法");
        userService.updateUserInfo(user);
        System.out.println("#####################   更新成功  ###########################");
    }

    public static void addUserTest() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/application-context.xml");
        IDataUserService userService = applicationContext.getBean(IDataUserService.class);
        User user = new User();
        user.setUsername("liuse");
        user.setPassword("de");
        user.setAge(25);
        user.setSex("1");
        user.setStatus("1");
        user.setUpdateTime(new Date());
        user.setCreateTime(new Date());
        int primaryKey = userService.addUserInfo(user);
        System.out.println("#####################   新增成功 " + primaryKey + " ###########################");
    }

    public static void statementTransactionTest() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/application-context.xml");
        StatementTransactionService statementTransactionService = applicationContext.getBean(StatementTransactionService.class);
        try {
            statementTransactionService.noTrancationUpdateUserInfo();
        } catch (Exception e) {
            System.out.println("  No Transaction Exception");
        }


        try {
            statementTransactionService.updateUserInfo();
        } catch (Exception e) {
            System.out.println("  Transaction Exception");
        }

    }


    public static void annotationTransactionTest() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/application-context.xml");
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

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/application-context.xml");
        StatementTransactionService statementTransactionService = applicationContext.getBean(StatementTransactionService.class);

        statementTransactionService.updateUserInfoTest();
    }
}
