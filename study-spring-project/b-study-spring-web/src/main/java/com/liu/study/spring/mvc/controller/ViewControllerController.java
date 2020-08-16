package com.liu.study.spring.mvc.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Liuweian
 * @version 1.0.0
 * @desc
 * @createTime 2020/5/27 14:17
 */
public class ViewControllerController implements Controller {

    private static final String CONTROLLER_VIEW = "controller";

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView(CONTROLLER_VIEW);
        modelAndView.addObject("username", "控制器");
        System.out.println("This is ViewControllerController");
        return modelAndView;
    }
}
