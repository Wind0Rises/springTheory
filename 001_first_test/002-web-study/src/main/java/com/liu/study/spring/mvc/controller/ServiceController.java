package com.liu.study.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @desc    使用@Service进行测试。
 * @author Liuweian
 * @createTime 2020/5/24 21:50
 * @version 1.0.0
 */
@Service
@RequestMapping("/spring/service")
public class ServiceController {

    @ResponseBody
    @RequestMapping("/test")
    public String serviceTestMethod() {
        return "success";
    }

}
