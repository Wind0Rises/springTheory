package com.liu.study.spring.data.transaction.propagate;

/**
 * @author lwa
 * @version 1.0.0
 * @createTime 2021/2/26 16:58
 */
public interface IAnnotationTransactionPropagateMandatoryService {

    void openTransaction(int method) throws Exception;

    void firstWayIsAHaveTransaction() throws Exception;

    void firstWayIsBNoHaveTransaction() throws Exception;

    void secondWayIsAHaveTransaction() throws Exception;

    void secondWayIsBNoHaveTransaction() throws Exception;

    void threeWayIsAHaveTransaction() throws Exception;

    void threeWayIsBNoHaveTransaction() throws Exception;

}
