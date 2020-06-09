package com.liu.study.spring.aop.cglib.chain;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc
 * @author Liuweian
 * @version 1.0.0
 * @createTime 2020/5/20 16:15
 */
public class AdvisorChain {

    List<AdvisorService> advisorChains = null;

    private int size = 0;

    public AdvisorChain() {
    }

    public AdvisorChain(List<AdvisorService> advisorChains) {
        this.advisorChains = advisorChains;
    }

    public Object process() {
        size++;
        if (size > advisorChains.size()) {
            return new ChainMerchantService().merchantServiceMethod();
        } else {
            return advisorChains.get(size - 1).advisor(this);
        }

    }

}
