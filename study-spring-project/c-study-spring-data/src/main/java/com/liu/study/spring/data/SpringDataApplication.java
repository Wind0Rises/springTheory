package com.liu.study.spring.data;

import com.liu.study.spring.data.model.User;
import com.liu.study.spring.data.service.IDataUserService;
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
        firstMainTest();
        // updateUserTest();
        // addUserTest();
    }

    /**
     * 接入Data第一个测试。
     */
    public static void firstMainTest() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/statement-application-context.xml");
        IDataUserService userService = applicationContext.getBean(IDataUserService.class);
        User user = userService.queryUserInfo(1);
        System.out.println("获取的用户信息为：" + user.toString());
    }


    /**
     * update操作测试
     */
    public static void updateUserTest() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/statement-application-context.xml");
        IDataUserService userService = applicationContext.getBean(IDataUserService.class);
        User user = userService.queryUserInfo(2);
        user.setUsername("阿的说法");
        userService.updateUserInfo(user);
        System.out.println("#####################   更新成功  ###########################");
    }

    /**
     * add操作测试。
     */
    public static void addUserTest() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/statement-application-context.xml");
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



}
