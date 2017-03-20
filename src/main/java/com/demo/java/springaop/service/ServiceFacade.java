package com.demo.java.springaop.service;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by weimaosheng on 2016/10/10.
 */
public class ServiceFacade {
    @Autowired
    private ServiceBook serviceBook;

    @Autowired
    private ServiceUser serviceUser;

    public ServiceBook getServiceBook() {
        return serviceBook;
    }

    public void setServiceBook(ServiceBook serviceBook) {
        this.serviceBook = serviceBook;
    }

    public ServiceUser getServiceUser() {
        return serviceUser;
    }

    public void setServiceUser(ServiceUser serviceUser) {
        this.serviceUser = serviceUser;
    }

    /**
     * TODO
     * 1.我可以认为这个方法中有两个事物吗？
     * 2.
     */
    public void addUserBook(){
//        try{
//        }catch (RuntimeException e){
//            e.printStackTrace();
//        }
        /**
         * 测试REQUIRES_NEW：事务挂起相当于事务不存在。
         *
         * addUserBook存在事务
         * addBook存在的事务传播行为为REQUIRES_NEW
         * addUser不存在事务
         *
         * 执行到addBook的时候，addUserBook的事务被挂起，addUser抛出异常
         *
         * 当addUser报错时，因事务被挂起：
         * addBook按照自己的事务执行；
         * addUser也按照自己的事务执行；
         */
        serviceBook.addBook();
        serviceUser.addUser();
    }
}
