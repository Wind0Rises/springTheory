package com.liu.study.spring.mvc.controller.interfa;

import org.springframework.stereotype.Service;

/**
 * @desc 
 * @author Liuweian
 * @createTime 2020/5/24 21:56
 * @version 1.0.0
 */
@Service
public class InterfaceControllerImpl implements InterfaceController {

    @Override
    public String interfaceTestMethod() {
        return "liu";
    }

}
