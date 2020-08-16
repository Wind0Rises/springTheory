package com.liu.study.spring.data.service.impl;

import com.liu.study.spring.data.dao.UserMapper;
import com.liu.study.spring.data.model.User;
import com.liu.study.spring.data.service.IDataUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @desc 
 * @author Liuweian
 * @createTime 2020/6/9 14:41
 * @version 1.0.0
 */
@Service
public class DataUserServiceImpl implements IDataUserService {

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
}
