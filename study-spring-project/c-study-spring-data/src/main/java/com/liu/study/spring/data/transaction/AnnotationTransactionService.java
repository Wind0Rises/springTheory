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
     * 如果能够插入成功，说明没有事务。
     *
     * @throws Exception
     */
    public void noTransactionUpdateUserInfo() throws Exception {
        User user = new User();
        user.setUsername("annotation_no_transaction");
        user.setPassword("de");
        user.setAge(25);
        user.setSex("1");
        user.setStatus("1");
        user.setUpdateTime(new Date());
        user.setCreateTime(new Date());

        userMapper.addUserInfo(user);

        if ("annotation_no_transaction".equals(user.getUsername())) {
            System.out.println("###########################   annotation_no_transaction  【抛异常了】   ###########################");
            throw new Exception();
        }
    }

    /**
     * 如果能够插入不成功，这事务生效
     *
     * @throws Exception
     */
    @Transactional(value = "transactionManager", isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void hasTransactionAddUserInfo() throws Exception {
        User user = new User();
        user.setUsername("annotation_has_transaction");
        user.setPassword("de");
        user.setAge(25);
        user.setSex("1");
        user.setStatus("1");
        user.setUpdateTime(new Date());
        user.setCreateTime(new Date());

        userMapper.addUserInfo(user);
        if ("annotation_has_transaction".equals(user.getUsername())) {
            System.out.println("=====================    hasTransactionAddUserInfo  【抛异常了】   ###########################");
            throw new Exception();
        }
    }

    /**
     * 内部方法时，事务是【不会】生效的。
     */
    public void innerMethodInvokeTransaction() throws Exception {
        innerMethod();
    }

    /**
     * @Transaction 必须使用public修饰。
     */
    @Transactional(value = "transactionManager", isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void innerMethod() throws Exception {
        User user = new User();
        user.setUsername("inner_method_invoke_transaction");
        user.setPassword("de");
        user.setAge(25);
        user.setSex("1");
        user.setStatus("1");
        user.setUpdateTime(new Date());
        user.setCreateTime(new Date());

        userMapper.addUserInfo(user);
        if ("inner_method_invoke_transaction".equals(user.getUsername())) {
            System.out.println("=====================    hasTransactionAddUserInfo  【抛异常了】   ###########################");
            throw new Exception();
        }
    }

}
