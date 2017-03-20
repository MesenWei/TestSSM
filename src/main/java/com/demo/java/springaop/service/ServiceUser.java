package com.demo.java.springaop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by weimaosheng on 2016/10/10.
 */
public class ServiceUser {
    public static final String ADD_USER="insert into t_user(id,name) values(1,'userrrrrrrrrrrr')";

    @Autowired
    private ServiceBook serviceBook;
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addUser(){
//        this.serviceBook.addBook();

        this.jdbcTemplate.execute(ADD_USER);

//        throw new RuntimeException("ccccccccccccccccc");

        /**
         * abc方法不存在事务，但是addUser存在事务，
         * 所以仍然会回滚
         */
        abc();
    }

    public void abc(){
        throw new RuntimeException("ccccccccccccccccc");
    }

    public ServiceBook getServiceBook() {
        return serviceBook;
    }

    public void setServiceBook(ServiceBook serviceBook) {
        this.serviceBook = serviceBook;
    }
}
