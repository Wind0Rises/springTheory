package com.liu.study.spring.post.bean;

import com.liu.study.spring.aop.PointCut;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.TimeUnit;

/**
 * @desc
 * @author Liuweian
 * @version 1.0.0
 * @createTime 2020/5/16 16:29
 */
public class BeanPostProcessTest {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-post.xml");
        IUserService wechatUser = (IUserService) context.getBean("wechatUser");
        System.out.println("========== 如果没有CustomBeanPostProcess 这里实际应该打印wechat =======");
        wechatUser.printUserName();
        TimeUnit.SECONDS.sleep(1000);
    }

}
