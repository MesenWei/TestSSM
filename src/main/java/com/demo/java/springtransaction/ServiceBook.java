package com.demo.java.springtransaction;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by weimaosheng on 2016/10/10.
 */
public class ServiceBook {
    public static final String ADD_BOOK="insert into t_book(id,name) values(1,'bookkkkkkkkkkkkk')";
    private JdbcTemplate jdbcTemplate ;

    public void addBook(){
        this.jdbcTemplate.execute(ADD_BOOK);
//        throw new RuntimeException("bbbbbbbbbbbbbbb");
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
