package com.liu.study.spring.data.transaction.propagate.impl;

import com.liu.study.spring.data.dao.UserMapper;
import com.liu.study.spring.data.model.User;
import com.liu.study.spring.data.transaction.propagate.IAnnotationTransactionPropagateRequiredService;
import lombok.Setter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Date;

/**
 * @author Liuweian
 * @version 1.0.0
 * @desc
 * @createTime 2020/6/9 18:20
 */
@Service
public class AnnotationTransactionPropagateRequiredServiceImpl implements IAnnotationTransactionPropagateRequiredService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IAnnotationTransactionPropagateRequiredService requiredService;

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
    /**
     *          A                 ->            B
     * FirstWayIsAHaveTransaction -> FirstWayIsANoHaveTransaction
     *
     * FirstWayIsANoHaveTransaction()方法抛出异常，判断FirstWayIsAHaveTransaction()是否回滚。
     * 如果【方式一：A有事务】插入成功，说明事务没有生效，如果插入成功，说明事务生效了。
     */
    @Transactional(value = "transactionManager",
            isolation = Isolation.READ_COMMITTED,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public void firstWayIsAHaveTransaction() throws Exception {
        User user = new User();
        user.setUsername("方式一：A有事务");
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
        requiredService.firstWayIsBNoHaveTransaction();
    }

    public void firstWayIsBNoHaveTransaction() throws Exception {
        User user = new User();
        user.setUsername("方式一：B没有事务");
        user.setPassword("-----");
        user.setAge(25);
        user.setSex("1");
        user.setStatus("1");
        user.setUpdateTime(new Date());
        user.setCreateTime(new Date());
        userMapper.addUserInfo(user);
        if ("方式一：B没有事务".equals(user.getUsername())) {
            throw new Exception("###########################   FirstWayIsBNoHaveTransaction  方式一：B没有事务，【抛出异常】   ###############");
        }
    }



    // #################################     方式二：A有事务，B有事务   #####################################################

    /**
     * secondWayIsAHaveTransaction()如果【方式二：B没有事务】插入成功，事务生效，如果插入失败，事务起作用。
     *
     * @throws Exception
     */
    @Transactional(value = "transactionManager",
            isolation = Isolation.READ_COMMITTED,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public void secondWayIsAHaveTransaction() throws Exception {
        /**
         * B
         */
        requiredService.secondWayIsBNoHaveTransaction();

        User user = new User();
        user.setUsername("方式二：A有事务");
        user.setPassword("-----");
        user.setAge(25);
        user.setSex("1");
        user.setStatus("1");
        user.setUpdateTime(new Date());
        user.setCreateTime(new Date());
        userMapper.addUserInfo(user);
        if ("方式二：A有事务".equals(user.getUsername())) {
            throw new Exception("###########################   secondWayIsBNoHaveTransaction  方式一：B没有事务，【抛出异常】   ###############");
        }
    }

    @Transactional(value = "transactionManager",
            isolation = Isolation.READ_COMMITTED,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public void secondWayIsBNoHaveTransaction() throws Exception {
        User user = new User();
        user.setUsername("方式二：B有事务");
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
    public void threeWayIsAHaveTransaction() throws Exception {
        /**
         * B
         */
        requiredService.threeWayIsBNoHaveTransaction();

        User user = new User();
        user.setUsername("方式三：A没有事务");
        user.setPassword("-----");
        user.setAge(25);
        user.setSex("1");
        user.setStatus("1");
        user.setUpdateTime(new Date());
        user.setCreateTime(new Date());
        userMapper.addUserInfo(user);
        if ("方式三：A没有事务".equals(user.getUsername())) {
            throw new Exception("###########################   threeWayIsBNoHaveTransaction  方式三：B没有事务，【抛出异常】   ###############");
        }
    }

    @Transactional(value = "transactionManager",
            isolation = Isolation.READ_COMMITTED,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public void threeWayIsBNoHaveTransaction() throws Exception {
        User user = new User();
        user.setUsername("方式三：B有事务");
        user.setPassword("-----");
        user.setAge(25);
        user.setSex("1");
        user.setStatus("1");
        user.setUpdateTime(new Date());
        user.setCreateTime(new Date());
        userMapper.addUserInfo(user);
    }

}
