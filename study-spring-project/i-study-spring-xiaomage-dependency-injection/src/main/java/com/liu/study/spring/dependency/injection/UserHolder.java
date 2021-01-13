package com.liu.study.spring.dependency.injection;

import com.liu.study.spring.xiaomage.first.dependency.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Liuweian
 * @createTime 2021/1/12 22:09
 * @version 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserHolder {

    private User user;

}
