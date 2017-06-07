package com.demo.java.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * Created by maosheng on 2017/5/23.
 */
@XmlRootElement(name = "orgs")
@XmlAccessorType(XmlAccessType.FIELD)
public class TestOrgParent {
    @XmlElement(name = "org_id")
    private Long orgId;
    @XmlElement(name = "parent_id")
    private Long parentId;
    @XmlElement(name = "org_name")
    private String orgName;
    @XmlElement(name = "org_code")
    private String orgCode;
    @XmlElement(name = "org_type")
    private String orgType;

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

}