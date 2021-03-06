package com.liu.study.spring.data.transaction.propagate.impl;

import com.liu.study.spring.data.dao.UserMapper;
import com.liu.study.spring.data.model.User;
import com.liu.study.spring.data.transaction.propagate.IAnnotationTransactionPropagateNestedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.Date;

/**
 * @author Liuweian
 * @version 1.0.0
 * @desc
 * @createTime 2020/6/9 18:20
 */
@Service
public class AnnotationTransactionPropagateNestedServiceImpl implements IAnnotationTransactionPropagateNestedService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IAnnotationTransactionPropagateNestedService nestedService;

    /**
     * 传播：肯定有多个方法的调用。


    // #################################     方式一：A有事务，B没有事务   #####################################################

    /**
     *          A                 ->            B
     * FirstWayIsAHaveTransaction -> FirstWayIsANoHaveTransaction
     *
     */
    @Override
    @Transactional(value = "transactionManager",
            isolation = Isolation.READ_COMMITTED,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public void firstWayIsAHaveTransaction() throws Exception {
        User user = new User();
        System.out.println("A 存在事务？" + TransactionSynchronizationManager.isActualTransactionActive() + "事务名称：" +
                TransactionSynchronizationManager.getCurrentTransactionName());
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
        nestedService.firstWayIsBNoHaveTransaction();
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
        System.out.println("B 存在事务？" + TransactionSynchronizationManager.isActualTransactionActive() + "事务名称：" +
                TransactionSynchronizationManager.getCurrentTransactionName());
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
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public void secondWayIsAHaveTransaction() throws Exception {
        User user = new User();
        user.setUsername("way_2: A have transaction");
        user.setPassword("-----");
        user.setAge(25);
        user.setSex("1");
        user.setStatus("1");
        user.setUpdateTime(new Date());
        user.setCreateTime(new Date());
        System.out.println("A 存在事务？" + TransactionSynchronizationManager.isActualTransactionActive() + "事务名称：" +
                TransactionSynchronizationManager.getCurrentTransactionName());
        userMapper.addUserInfo(user);

        /**
         * B
         */
        nestedService.secondWayIsBHaveTransaction();
    }

    @Transactional(value = "transactionManager",
            isolation = Isolation.READ_COMMITTED,
            propagation = Propagation.NESTED,
            rollbackFor = Exception.class)
    public void secondWayIsBHaveTransaction() throws Exception {
        User user = new User();
        user.setUsername("way_2: B have transaction");
        user.setPassword("-----");
        user.setAge(25);
        user.setSex("1");
        user.setStatus("1");
        user.setUpdateTime(new Date());
        user.setCreateTime(new Date());
        System.out.println("B 存在事务？" + TransactionSynchronizationManager.isActualTransactionActive() + "事务名称：" +
                TransactionSynchronizationManager.getCurrentTransactionName());
        userMapper.addUserInfo(user);
        if ("way_2: B have transaction".equals(user.getUsername())) {
            throw new Exception("###########################   secondWayIsBNoHaveTransaction  方式一：B有事务，【抛出异常】   ###############");
        }
    }



    // #################################     方式三：A没有事务，B没有事务   #####################################################

    /**
     *
     *
     */
    @Override
    public void threeWayIsAHaveTransaction() throws Exception {
        /**
         * B
         */
        nestedService.threeWayIsBNoHaveTransaction();

        User user = new User();
        user.setUsername("way_3: A no have transaction");
        user.setPassword("-----");
        user.setAge(25);
        user.setSex("1");
        user.setStatus("1");
        user.setUpdateTime(new Date());
        user.setCreateTime(new Date());
        userMapper.addUserInfo(user);
        System.out.println("A 存在事务？" + TransactionSynchronizationManager.isActualTransactionActive());
        if ("way_3: A no have transaction".equals(user.getUsername())) {
            throw new Exception("###########################   threeWayIsBNoHaveTransaction  方式三：B没有事务，【抛出异常】   ###############");
        }
    }

    @Override
    @Transactional(value = "transactionManager",
            isolation = Isolation.READ_COMMITTED,
            propagation = Propagation.NESTED,
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
        System.out.println("B 存在事务？" + TransactionSynchronizationManager.isActualTransactionActive());
        userMapper.addUserInfo(user);
    }

}
