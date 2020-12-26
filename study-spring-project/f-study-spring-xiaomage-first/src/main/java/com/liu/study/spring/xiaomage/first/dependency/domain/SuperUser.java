package com.liu.study.spring.xiaomage.first.dependency.domain;

import com.liu.study.spring.xiaomage.first.dependency.annotation.Super;
import lombok.Data;

/**
 * 
 * @author Liuweian
 * @createTime 2020/12/19 17:23
 * @version 1.0.0
 */
@Super
@Data
public class SuperUser extends User {

    private String address;

}
