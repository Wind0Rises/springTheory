package com.liu.study.spring.data.transaction.propagate.impl;

import com.liu.study.spring.data.dao.UserMapper;
import com.liu.study.spring.data.model.User;
import com.liu.study.spring.data.transaction.propagate.IAnnotationTransactionPropagateSupportService;
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
public class AnnotationTransactionPropagateSupportServiceImpl implements IAnnotationTransactionPropagateSupportService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IAnnotationTransactionPropagateSupportService supportService;

    /**
     * 传播：肯定有多个方法的调用。
     *
     * 方法A；方法B
     *
     * 方式一：A有事务，B没有事务
     * 方式二：A有事务，B有事务
     * 方式三：A没有事务，B没有事务
     * 方式四：A没有事务，B有事务
     */


    // #################################     方式一：A有事务，B没有事务   #####################################################

    @Override
    @Transactional(value = "transactionManager",
            isolation = Isolation.READ_COMMITTED,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public void openTransaction(int method) throws Exception {
        if (1 == method) {
            supportService.firstWayIsAHaveTransaction();
        } else if (2 == method) {
            supportService.secondWayIsAHaveTransaction();
        }
    }

    /**
     *          A                 ->            B
     * FirstWayIsAHaveTransaction -> FirstWayIsANoHaveTransaction
     *
     * FirstWayIsANoHaveTransaction()方法抛出异常，判断FirstWayIsAHaveTransaction()是否回滚。
     *
     * way_1：A have transaction：插入失败，支持当前事务。
     * way_1：B no have transaction：插入失败，支持当前事务。
     *
     */
    @Override
    @Transactional(value = "transactionManager",
            isolation = Isolation.READ_COMMITTED,
            propagation = Propagation.SUPPORTS,
            rollbackFor = Exception.class)
    public void firstWayIsAHaveTransaction() throws Exception {
        User user = new User();
        user.setUsername("way_1: A have transaction");
        user.setPassword("-----");
        user.setAge(25);
        user.setSex("1");
        user.setStatus("1");
        user.setUpdateTime(new Date());
        user.setCreateTime(new Date());
        userMapper.addUserInfo(user);

        /**
         * B
         */
        supportService.firstWayIsBNoHaveTransaction();
    }

    @Override
    public void firstWayIsBNoHaveTransaction() throws Exception {
        User user = new User();
        user.setUsername("way_1: B no have transaction");
        user.setPassword("-----");
        user.setAge(25);
        user.setSex("1");
        user.setStatus("1");
        user.setUpdateTime(new Date());
        user.setCreateTime(new Date());
        userMapper.addUserInfo(user);
        if ("way_1: B no have transaction".equals(user.getUsername())) {
            throw new Exception("###########################   FirstWayIsBNoHaveTransaction  方式一：B没有事务，【抛出异常】   ###############");
        }
    }



    // #################################     方式二：A有事务，B有事务   #####################################################

    /**
     *
     */
    @Override
    @Transactional(value = "transactionManager",
            isolation = Isolation.READ_COMMITTED,
            propagation = Propagation.SUPPORTS,
            rollbackFor = Exception.class)
    public void secondWayIsAHaveTransaction() throws Exception {
        /**
         * B
         */
        supportService.secondWayIsBNoHaveTransaction();

        User user = new User();
        user.setUsername("way_2: A have transaction");
        user.setPassword("-----");
        user.setAge(25);
        user.setSex("1");
        user.setStatus("1");
        user.setUpdateTime(new Date());
        user.setCreateTime(new Date());
        userMapper.addUserInfo(user);
        if ("way_2: A have transaction".equals(user.getUsername())) {
            throw new Exception("###########################   secondWayIsBNoHaveTransaction  方式一：B没有事务，【抛出异常】   ###############");
        }
    }

    @Override
    @Transactional(value = "transactionManager",
            isolation = Isolation.READ_COMMITTED,
            propagation = Propagation.SUPPORTS,
            rollbackFor = Exception.class)
    public void secondWayIsBNoHaveTransaction() throws Exception {
        User user = new User();
        user.setUsername("way_2: B have transaction");
        user.setPassword("-----");
        user.setAge(25);
        user.setSex("1");
        user.setStatus("1");
        user.setUpdateTime(new Date());
        user.setCreateTime(new Date());
        userMapper.addUserInfo(user);
    }



    // #################################     方式三：A没有事务，B没有事务   #####################################################

    /**
     * threeWayIsAHaveTransaction()：能插入成功，因为threeWayIsAHaveTransaction()没有事务
     * threeWayIsBNoHaveTransaction()：能插入成功，因为threeWayIsBNoHaveTransaction()有事务，但是threeWayIsBNoHaveTransaction（）
     * 没有抛出，方法执行结束，事务提交。
     *
     */
    @Override
    public void threeWayIsAHaveTransaction() throws Exception {
        /**
         * B
         */
        supportService.threeWayIsBNoHaveTransaction();

        User user = new User();
        user.setUsername("way_3: A no have transaction");
        user.setPassword("-----");
        user.setAge(25);
        user.setSex("1");
        user.setStatus("1");
        user.setUpdateTime(new Date());
        user.setCreateTime(new Date());
        userMapper.addUserInfo(user);
        if ("way_3: A no have transaction".equals(user.getUsername())) {
            throw new Exception("###########################   threeWayIsBNoHaveTransaction  方式三：B没有事务，【抛出异常】   ###############");
        }
    }

    @Override
    @Transactional(value = "transactionManager",
            isolation = Isolation.READ_COMMITTED,
            propagation = Propagation.SUPPORTS,
            rollbackFor = Exception.class)
    public void threeWayIsBNoHaveTransaction() throws Exception {
        User user = new User();
        user.setUsername("way_3: B have transaction");
        user.setPassword("-----");
        user.setAge(25);
        user.setSex("1");
        user.setStatus("1");
        user.setUpdateTime(new Date());
        user.setCreateTime(new Date());
        userMapper.addUserInfo(user);
    }

}
