package com.liu.study.spring.mvc.controller.inherit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @desc 
 * @author Liuweian
 * @createTime 2020/5/24 22:07
 * @version 1.0.0
 */
@RequestMapping("/spring/inherit/v1")
@Controller
public class ChildController extends SuperController {


    /**
     * ############################################################################
     * #            注意请求/spring/inherit/v1/test和/spring/inherit/test的区别     #
     * #            这两个返回的是【【不】】同的。                                    #
     * ############################################################################
     *
     */
    @Override
    public String inheritTestMethod() {
        System.out.println("This is Child Controller");
        return "Child Controller";
    }

    /**
     * ############################################################################
     * #            注意请求/spring/inherit/v1/test和/spring/inherit/test的区别     #
     * #            这两个返回的是【【相同】】的。                                    #
     * ############################################################################
     *
     */
    @Override
    public String inheritManyUrl() {
        return super.inheritManyUrl();
    }
}
