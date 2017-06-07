package com.demo.java.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;


/**
 * Created by maosheng on 2017/5/23.
 */
@XmlRootElement(name = "orgs")
@XmlAccessorType(XmlAccessType.FIELD)
public class TestOrgChildren extends TestOrgParent{
    @XmlElement(name = "start_d")
    private Date startDate;
    @XmlElement(name = "end_d")
    private Date endDate;
    @XmlElement(name = "attribute1")
    private String attribute;
    @XmlElement(name = "insert_t")
    private Date insertTime;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
}