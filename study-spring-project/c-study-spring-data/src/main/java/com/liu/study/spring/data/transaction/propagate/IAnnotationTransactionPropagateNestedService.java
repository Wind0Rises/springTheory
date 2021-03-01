package com.liu.study.spring.data.transaction.propagate;

/**
 * @author lwa
 * @version 1.0.0
 * @createTime 2021/2/26 16:58
 */
public interface IAnnotationTransactionPropagateNestedService {

    void firstWayIsAHaveTransaction() throws Exception;

    void firstWayIsBNoHaveTransaction() throws Exception;

    void secondWayIsAHaveTransaction() throws Exception;

    void secondWayIsBHaveTransaction() throws Exception;

    void threeWayIsAHaveTransaction() throws Exception;

    void threeWayIsBNoHaveTransaction() throws Exception;

}
