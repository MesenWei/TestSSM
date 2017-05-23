package com.demo.java.xml;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by maosheng on 2017/5/23.
 */
@SuppressWarnings("serial")
@XmlRootElement(name = "orgs")
@XmlAccessorType(XmlAccessType.FIELD)
public class TestOrgs extends ArrayList<TestOrg> {
    @XmlAttribute(name = "size")
    private int size;
    @XmlAttribute(name = "batch_number")
    private Long batchNumber;
    @XmlAttribute(name = "errmsg")
    private String errmsg;

    @XmlElement(name = "org")
    public List<TestOrg> getOrgs() {
        return this;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Long getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(Long batchNumber) {
        this.batchNumber = batchNumber;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

}
