package com.demo.java.spring.resttemplate;

import java.util.Date;

public class HrWecorpCheckingUser {
    private String userId;

    private Date createTime;

    public HrWecorpCheckingUser(String userId) {
        this.userId = userId;
    }

    public HrWecorpCheckingUser() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}