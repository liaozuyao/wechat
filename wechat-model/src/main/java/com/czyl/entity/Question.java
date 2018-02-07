package com.czyl.entity;

import java.util.Date;

public class Question{

    private Long id;

    private String title;

    private Long fieldId;

    private Integer urgent;

    private String file;

    private String describe;

    private Integer status;

    private Date createTime;

    private Date hopeTime;

    private Long companyId;

    private Long adviserId;

    private Integer changeUser;

    public Integer getChangeUser() {
        return changeUser;
    }

    public void setChangeUser(Integer changeUser) {
        this.changeUser = changeUser;
    }

    public Long getAdviserId() {
        return adviserId;
    }

    public void setAdviserId(Long adviserId) {
        this.adviserId = adviserId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getFieldId() {
        return fieldId;
    }

    public void setFieldId(Long fieldId) {
        this.fieldId = fieldId;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Integer getUrgent() {
        return urgent;
    }

    public void setUrgent(Integer urgent) {
        this.urgent = urgent;
    }

    public Date getHopeTime() {
        return hopeTime;
    }

    public void setHopeTime(Date hopeTime) {
        this.hopeTime = hopeTime;
    }
}