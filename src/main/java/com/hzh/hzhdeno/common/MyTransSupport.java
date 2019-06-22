package com.hzh.hzhdeno.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;


/**
 * @author Administrator
 * @eg. public boolean create {
 * TransactionStatus status = getTxStatus();
 * boolean r = true;
 * try{
 * r = create();
 * }catch(Exception e){
 * r = false;
 * }finally{
 * commit(status, r);
 * }
 * return r;
 * }
 */
public class MyTransSupport {
//    @Autowired
//    public DataSourceTransactionManager transactionManagerWrite;
//
//
//    private TransactionDefinition getTxDef() {
//        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
//        def.setName(this.getClass().getName() + System.currentTimeMillis());
//        def.setReadOnly(false);
//        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
//        return def;
//    }
//
//    private DataSourceTransactionManager getTxManagerWrite() {
//        return transactionManagerWrite;
//    }
//
//    public TransactionStatus getTxStatus() {
//        return getTxManagerWrite().getTransaction(getTxDef());
//    }
//
//    public boolean commit(TransactionStatus status, boolean r) {
//        if (r) {
//            transactionManagerWrite.commit(status);
//        } else {
//            transactionManagerWrite.rollback(status);
//        }
//        return r;
//    }
}
