package com.liu.study.spring.mvc.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @desc 自定义
 * @author Liuweian
 * @createTime 2020/5/22 21:34
 * @version 1.0.0
 */
public class CustomServlet implements Servlet {

    private ServletConfig servletConfig;

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("This is CustomServlet.init");
        this.servletConfig = config;
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
