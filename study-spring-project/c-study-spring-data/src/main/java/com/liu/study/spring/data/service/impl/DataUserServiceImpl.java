package com.liu.study.spring.data.service.impl;

import com.liu.study.spring.data.dao.UserMapper;
import com.liu.study.spring.data.model.User;
import com.liu.study.spring.data.service.IDataUserService;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.beans.PropertyDescriptor;

/**
 * @desc 
 * @author Liuweian
 * @createTime 2020/6/9 14:41
 * @version 1.0.0
 */
@Service
public class DataUserServiceImpl implements IDataUserService, InstantiationAwareBeanPostProcessor {

    @PostConstruct
    public void postConstruct() {
        System.out.println("-------------------------");
    }

    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryUserInfo(int id) {
        User user = userMapper.selectUserBySeq(id);
        System.out.println(user.toString());
        return user;
    }

    @Override
    public void updateUserInfo(User user) {
        userMapper.updateUserBySeq(user);
    }

    @Override
    public int addUserInfo(User user) {
        return userMapper.addUserInfo(user);
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        return false;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }
}
