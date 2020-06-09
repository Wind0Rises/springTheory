package com.liu.study.spring.post.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @desc
 * @author Liuweian
 * @version 1.0.0
 * @createTime 2020/5/16 16:23
 */
public class CustomBeanPostProcess implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        if(bean instanceof WechatUserServiceImpl) {
            System.out.println("======【注意】=====这里把wechat User改为了Ali User");
            return bean = new AliUserServiceImpl();
        }

        return bean;
    }
}
