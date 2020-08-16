package com.liu.study.spring.data.service;

import com.liu.study.spring.data.model.User;

/**
 * @desc 
 * @author Liuweian
 * @createTime 2020/6/9 14:41
 * @version 1.0.0
 */
public interface IDataUserService {

    /**
     * @desc 
     * @author Liuweian
     * @createTime 2020/6/9 14:45
     */
    public User queryUserInfo(int id);


    /**
     *
     * @param user
     */
    public void updateUserInfo(User user);


    /**
     * @desc
     * @author Liuweian
     * @version 1.0.0
     */
    public int addUserInfo(User user);
}
