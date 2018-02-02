package com.czyl.dto;

import java.util.Date;

/**
 * Created by liaozuyao on 2017/12/26.
 */
public class QuestionDto {

    private Long id;

    private String title;

    private String field;

    private String node;

    private String phone;

    private String event;

    private String influence;

    private String urgent;

    private String original;

    private String originalMobile;

    private String originalPhone;

    private String originalMail;

    private String file;

    private String describe;

    private String status;

    private Date createTime;

    private String strTime;

    private String userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getInfluence() {
        return influence;
    }

    public void setInfluence(String influence) {
        this.influence = influence;
    }

    public String getUrgent() {
        return urgent;
    }

    public void setUrgent(String urgent) {
        this.urgent = urgent;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getOriginalMobile() {
        return originalMobile;
    }

    public void setOriginalMobile(String originalMobile) {
        this.originalMobile = originalMobile;
    }

    public String getOriginalPhone() {
        return originalPhone;
    }

    public void setOriginalPhone(String originalPhone) {
        this.originalPhone = originalPhone;
    }

    public String getOriginalMail() {
        return originalMail;
    }

    public void setOriginalMail(String originalMail) {
        this.originalMail = originalMail;
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


    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getStrTime() {
        return strTime;
    }

    public void setStrTime(String strTime) {
        this.strTime = strTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "QuestionDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", field='" + field + '\'' +
                ", node='" + node + '\'' +
                ", phone='" + phone + '\'' +
                ", event='" + event + '\'' +
                ", influence='" + influence + '\'' +
                ", urgent='" + urgent + '\'' +
                ", original='" + original + '\'' +
                ", originalMobile='" + originalMobile + '\'' +
                ", originalPhone='" + originalPhone + '\'' +
                ", originalMail='" + originalMail + '\'' +
                ", file='" + file + '\'' +
                ", describe='" + describe + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                ", strTime='" + strTime + '\'' +
                ", userId=" + userId +
                '}';
    }
}
