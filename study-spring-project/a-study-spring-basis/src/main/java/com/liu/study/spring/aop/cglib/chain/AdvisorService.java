package com.liu.study.spring.aop.cglib.chain;

/**
 * @desc 通知接口
 * @author Liuweian
 * @version 1.0.0
 * @createTime 2020/5/20 16:16
 */
public interface AdvisorService {

    public Object advisor(AdvisorChain advisorChain);

}
