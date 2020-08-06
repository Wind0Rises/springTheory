package com.liu.study.spring.mvc.controller;

import com.liu.study.spring.mvc.config.AnnotationBeanInject;
import com.liu.study.spring.mvc.config.test.Car;
import com.liu.study.spring.mvc.config.test.Driver;
import com.liu.study.spring.mvc.config.test.ImportClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/8/5 19:29
 */
@Controller
@RequestMapping("/config")
public class ConfigurationTestController {

    @Autowired
    private AnnotationBeanInject annotationBeanInject;

    @RequestMapping("/test")
    @ResponseBody
    public void test() {
        annotationBeanInject.testAnnotationBeanInjectMethod();
    }


    @Autowired
    private Car car;

    @Autowired
    private Driver driver;

    /**
     * @see com.liu.study.spring.mvc.config.CustomConfig, 使用@Configuration注解，注释@Component注解。
     */
    @RequestMapping("/configuration")
    @ResponseBody
    public void configConfiguration() {
        System.out.println(car);
        System.out.println(driver.getCar());

    }

    /**
     * @see com.liu.study.spring.mvc.config.CustomConfig, 使用@Component注解，注释@Configuration注解。
     */
    @RequestMapping("/component")
    @ResponseBody
    public void configComponent() {
        System.out.println(car);
        System.out.println(driver.getCar());
    }


    @Autowired
    private ImportClass importClass;

    @RequestMapping("/import")
    @ResponseBody
    public void importTest() {
        importClass.test();
    }

}