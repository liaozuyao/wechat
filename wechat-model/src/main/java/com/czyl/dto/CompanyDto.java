package com.czyl.dto;

import java.util.Date;

public class CompanyDto {

    private Long id;
    private String name;
    private String code;
    private String contactName;
    private String contactPhone;
    private String contactMail;
    private Date createTime;
    private String serviceModelName;
    private String serviceEnclosure;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactMail() {
        return contactMail;
    }

    public void setContactMail(String contactMail) {
        this.contactMail = contactMail;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getServiceModelName() {
        return serviceModelName;
    }

    public void setServiceModelName(String serviceModelName) {
        this.serviceModelName = serviceModelName;
    }

    public String getServiceEnclosure() {
        return serviceEnclosure;
    }

    public void setServiceEnclosure(String serviceEnclosure) {
        this.serviceEnclosure = serviceEnclosure;
    }

    @Override
    public String toString() {
        return "CompanyDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", contactName='" + contactName + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                ", contactMail='" + contactMail + '\'' +
                ", createTime=" + createTime +
                ", serviceModelName='" + serviceModelName + '\'' +
                ", serviceEnclosure='" + serviceEnclosure + '\'' +
                '}';
    }
}
