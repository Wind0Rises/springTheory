package com.liu.study.spring.data.transaction.propagate.impl;

import com.liu.study.spring.data.dao.UserMapper;
import com.liu.study.spring.data.model.User;
import com.liu.study.spring.data.transaction.propagate.IAnnotationTransactionPropagateRequiredNewService;
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
public class AnnotationTransactionPropagateRequiredNewServiceImpl implements IAnnotationTransactionPropagateRequiredNewService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IAnnotationTransactionPropagateRequiredNewService requiredNewService;

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
            requiredNewService.firstWayIsAHaveTransaction();
        } else if (2 == method) {
            requiredNewService.secondWayIsAHaveTransaction();
        }
    }

    /**
     *  依赖调用方，是否存在事务。
     */
    @Override
    @Transactional(value = "transactionManager",
            isolation = Isolation.READ_COMMITTED,
            propagation = Propagation.REQUIRES_NEW,
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
        requiredNewService.firstWayIsBNoHaveTransaction();
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
            propagation = Propagation.REQUIRES_NEW,
            rollbackFor = Exception.class)
    public void secondWayIsAHaveTransaction() throws Exception {
        /**
         * B
         */
        requiredNewService.secondWayIsBNoHaveTransaction();

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
            propagation = Propagation.REQUIRES_NEW,
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
     *
     */
    @Override
    public void threeWayIsAHaveTransaction() throws Exception {
        /**
         * B
         */
        requiredNewService.threeWayIsBNoHaveTransaction();

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
            propagation = Propagation.REQUIRES_NEW,
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
