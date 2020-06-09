package com.liu.study.spring.mvc.controller.inherit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @desc 
 * @author Liuweian
 * @createTime 2020/5/24 22:04
 * @version 1.0.0
 */
@RequestMapping("/spring/inherit")
@Controller
public class SuperController {

    @RequestMapping("/test")
    @ResponseBody
    public String inheritTestMethod() {
        System.out.println("This is Super Controller");
        return "inherit";
    }


    @RequestMapping("/many")
    @ResponseBody
    public String inheritManyUrl() {
        System.out.println("This is Super =============");
        return "many";
    }

}
