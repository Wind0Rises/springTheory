package com.liu.study.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @desc 
 * @author Liuweian
 * @createTime 2020/5/22 22:08
 * @version 1.0.0
 */
@Controller
@RequestMapping("/spring")
public class CustomController {

    @RequestMapping("/first")
    @ResponseBody
    public String firstController() {
        System.out.println("This is CustomController.firstController Handler Mapping");
        return "success";
    }

}
