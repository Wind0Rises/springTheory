package com.liu.study.spring.aop.cglib.chain;

/**
 * @desc 商户服务
 * @author Liuweian
 * @version 1.0.0
 * @createTime 2020/5/20 16:37
 */
public class ChainMerchantService {

    public String merchantServiceMethod() {
        System.out.println("=====   chain  商户服务类   =======");
        return "MerchantService" ;
    }

}
