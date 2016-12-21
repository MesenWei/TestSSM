package com.hailstone.common.dao.po;

import java.util.List;

public class MyStudent {
    private String id;

    private String name;

    private String classid;

    private Long yuwen;

    private Long shuxue;

    //==============================================
    //=================所有增加的属性================
    //==============================================
    private List<MyCourse> listMyCourse;

    //==============================================

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getClassid() {
        return classid;
    }

    public void setClassid(String classid) {
        this.classid = classid == null ? null : classid.trim();
    }

    public Long getYuwen() {
        return yuwen;
    }

    public void setYuwen(Long yuwen) {
        this.yuwen = yuwen;
    }

    public Long getShuxue() {
        return shuxue;
    }

    public void setShuxue(Long shuxue) {
        this.shuxue = shuxue;
    }

    public List<MyCourse> getListMyCourse() {
        return listMyCourse;
    }

    public void setListMyCourse(List<MyCourse> listMyCourse) {
        this.listMyCourse = listMyCourse;
    }
}