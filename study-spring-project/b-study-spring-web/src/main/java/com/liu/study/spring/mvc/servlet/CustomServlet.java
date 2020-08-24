package com.liu.study.spring.mvc.servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.annotation.PostConstruct;
import javax.servlet.*;
import java.io.IOException;

/**
 * @desc 自定义
 *
 * this is CustomServlet Construct                      只会执行一次
 * This is CustomServlet.postConstructMethod            只会执行一次
 * This is CustomServlet.init                           只会执行一次
 * This is CustomServlet.service
 *
 * 执行顺序。
 *
 * @author Liuweian
 * @createTime 2020/5/22 21:34
 * @version 1.0.0
 */
public class CustomServlet implements Servlet {

    private ServletConfig servletConfig;

    public CustomServlet() {
        System.out.println("this is CustomServlet Construct");
    }

    /**
     *
     * @param config
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("This is CustomServlet.init");
        this.servletConfig = config;
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    /**
     * 依赖注入完成。
     */
    @PostConstruct
    public void postConstructMethod() {
        System.out.println("This is CustomServlet.postConstructMethod");
    }


    @Override
    public ServletConfig getServletConfig() {
        System.out.println("This is CustomServlet.getServletConfig");
        return this.servletConfig;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("This is CustomServlet.service");
        res.getOutputStream().write("suceess CustomServlet".getBytes());
    }

    @Override
    public String getServletInfo() {
        System.out.println("This is CustomServlet.getServletInfo");
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("This is CustomServlet.destroy");
    }
}
