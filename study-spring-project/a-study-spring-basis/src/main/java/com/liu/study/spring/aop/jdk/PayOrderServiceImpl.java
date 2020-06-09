package com.liu.study.spring.aop.jdk;

/**
 * @desc
 * @author Liuweian
 * @version 1.0.0
 * @createTime 2020/5/20 13:09
 */
public class PayOrderServiceImpl implements IOrderService {
    @Override
    public void getOrderMessage() {
        System.out.println("TTTTTTTT   this is Pay Order TTTTTTTTTT");
    }
}
