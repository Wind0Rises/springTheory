package com.liu.study.spring.defination.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @desc 
 * @author Liuweian
 * @createTime 2020/8/16 22:13
 * @version 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String username;

    private Integer age;

}
