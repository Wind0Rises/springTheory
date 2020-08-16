package com.liu.study.spring.data.dao;

import com.liu.study.spring.data.model.User;

/**
 * @author Liuweian
 * @version 1.0.0
 * @desc
 * @createTime 2020/6/9 14:45
 */
public interface UserMapper {

    public User selectUserBySeq(int userSeq);

    public void updateUserBySeq(User user);

    public int addUserInfo(User user);

}
