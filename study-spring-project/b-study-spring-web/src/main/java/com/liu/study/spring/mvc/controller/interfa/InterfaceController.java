package com.liu.study.spring.mvc.controller.interfa;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @desc 
 * @author Liuweian
 * @createTime 2020/5/24 21:55
 * @version 1.0.0
 */
@RequestMapping("spring/interface")
public interface InterfaceController {

    /**
     *
     */
    @RequestMapping("/test")
    @ResponseBody
    public String interfaceTestMethod();

}
