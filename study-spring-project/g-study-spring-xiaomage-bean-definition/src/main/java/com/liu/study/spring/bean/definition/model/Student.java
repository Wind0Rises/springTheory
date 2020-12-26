package com.liu.study.spring.bean.definition.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Liuweian
 * @createTime 2020/12/26 20:41
 * @version 1.0.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Student {

    private String username;

    private String like;

    private int age;

    public static Student createStudent() {
        Student build = Student.builder()
                .username("static method create student")
                .like("静态方法创建Student对象")
                .age(12).build();
        return build;
    }

}
