package com.liu.study.spring.mvc.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

/**
 * @desc
 * @author Liuweian
 * @version 1.0.0
 * @createTime 2020/5/27 16:55
 */
public class RequestDispatcherServletTest implements Servlet {

    private final static String JSP_NAME = "requestDispatcher";

    private final static String VIEW_PATH = "\\webapp\\WEB-INF\\view\\";

    private final static String FILE_SUFFIX = ".jsp";

    private ServletConfig servletConfig;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.servletConfig;
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        System.out.println("进入RequestDispatcherServletTest.service方法");
        request.setAttribute("username", "李二");
        String filePath = System.getProperty("user.dir") + VIEW_PATH + JSP_NAME + FILE_SUFFIX;
        request.getRequestDispatcher("/spring/requestDispatcher").forward(request, response);
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
