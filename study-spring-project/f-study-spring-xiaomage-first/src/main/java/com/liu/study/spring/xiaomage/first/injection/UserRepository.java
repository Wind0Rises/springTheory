package com.liu.study.spring.xiaomage.first.injection;

import com.liu.study.spring.xiaomage.first.dependency.domain.User;
import lombok.Data;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;

import java.util.Collection;

/**
 * 用户的信息仓库，
 *
 * 集合注入。
 *
 * @author Liuweian
 * @createTime 2020/12/24 21:16
 * @version 1.0.0
 */
@Data
public class UserRepository {

    private Collection<User> users;

    private BeanFactory beanFactory;

    private ObjectFactory<ApplicationContext> userObjectFactory;

}
