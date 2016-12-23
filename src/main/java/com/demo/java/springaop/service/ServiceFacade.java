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
        serviceBook.addBook();
        serviceUser.addUser();
    }
}
