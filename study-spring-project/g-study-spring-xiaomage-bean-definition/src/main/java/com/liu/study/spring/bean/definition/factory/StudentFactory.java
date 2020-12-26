package com.liu.study.spring.bean.definition.factory;

import com.liu.study.spring.bean.definition.model.Student;

/**
 * 
 * @author Liuweian
 * @createTime 2020/12/26 20:50
 * @version 1.0.0
 */
public interface StudentFactory {

    /**
     *   创建student对象方法。
     * @return
     */
    Student crateStudent();

}
