package com.liu.study.spring.data.transaction;

import com.liu.study.spring.data.dao.UserMapper;
import com.liu.study.spring.data.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author Liuweian
 * @version 1.0.0
 * @desc
 * @createTime 2020/6/9 18:20
 */
@Service
public class AnnotationTransactionService {

    @Autowired
    private UserMapper userMapper;

    /**
     *
     * @throws Exception
     */
    public void noTransactionUpdateUserInfo() throws Exception {
        User user = new User();
        user.setUsername("annotationNoTransaction");
        user.setPassword("de");
        user.setAge(25);
        user.setSex("1");
        user.setStatus("1");
        user.setUpdateTime(new Date());
        user.setCreateTime(new Date());

        userMapper.addUserInfo(user);

        if ("annotationNoTransaction".equals(user.getUsername())) {
            System.out.println("###########################");
            throw new Exception();
        }
    }

    @Transactional(value = "transactionManager", isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void updateUserInfo() throws Exception {

        User user = new User();
        user.setUsername("annotationTransaction");
        user.setPassword("de");
        user.setAge(25);
        user.setSex("1");
        user.setStatus("1");
        user.setUpdateTime(new Date());
        user.setCreateTime(new Date());

        userMapper.addUserInfo(user);

        if ("annotationTransaction".equals(user.getUsername())) {
            System.out.println("=====================");
            throw new Exception();
        }
    }

}
