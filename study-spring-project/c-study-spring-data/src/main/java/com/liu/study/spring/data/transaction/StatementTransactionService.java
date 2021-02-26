package com.liu.study.spring.data.transaction;

import com.liu.study.spring.data.dao.UserMapper;
import com.liu.study.spring.data.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @desc 
 * @author Liuweian
 * @createTime 2020/6/9 16:56
 * @version 1.0.0
 */
@Service
public class StatementTransactionService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 看该条数据有没有存入数据库，如果保存到数据库，就是没有事务。
     *
     * @throws Exception
     */
    public void noTransactionAddUserInfo() throws Exception {
        User user = new User();
        user.setUsername("statement_no_transaction");
        user.setPassword("de");
        user.setAge(25);
        user.setSex("1");
        user.setStatus("1");
        user.setUpdateTime(new Date());
        user.setCreateTime(new Date());


        userMapper.addUserInfo(user);
        if ("statement_no_transaction".equals(user.getUsername())) {
            System.out.println("###########################");
            throw new Exception();
        }
    }


    /**
     * 看该条数据有没有存入数据库，如果【没有】保存到数据库，就是没有事务。
     * @throws Exception
     */
    public void haveTransactionAddUserInfo() throws Exception  {
        User user = new User();
        user.setUsername("statement_has_transaction");
        user.setPassword("de");
        user.setAge(25);
        user.setSex("1");
        user.setStatus("1");
        user.setUpdateTime(new Date());
        user.setCreateTime(new Date());

        userMapper.addUserInfo(user);
        if ("statement_has_transaction".equals(user.getUsername())) {
            System.out.println("=====================");
            throw new Exception();
        }
    }
}
