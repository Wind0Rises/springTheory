package com.liu.study.spring.aop.cglib.chain;

/**
 * @desc 自定义第二个通知服务
 * @author Liuweian
 * @version 1.0.0
 * @createTime 2020/5/20 16:17
 */
public class CustomSecondAdvisorServiceImpl implements AdvisorService {

    @Override
    public Object advisor(AdvisorChain advisorChain) {
        System.out.println("==== 第二个  通知  服务  【开始】=========");
        Object result = advisorChain.process();
        System.out.println("==== 第二个  通知  服务  【结束】=========");
        return result;
    }

}
