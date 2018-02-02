package com.czyl.entity;

import java.util.Date;

public class Question{

    private Long id;

    private String title;

    private Long fieldId;

    private Long nodeId;

    private String phone;

    private Integer eventId;

    private Integer influence;

    private Integer urgent;

    private String original;

    private String originalMobile;

    private String originalPhone;

    private String originalMail;

    private String file;

    private String describe;

    private Integer status;

    private Date createTime;

    private String strTime;

    private Long userId;

//    public Question(String title, Long fieldId, Long nodeId, String phone, Integer eventId, Integer influence,
//                    Integer urgent, String original, String originalMobile, String originalPhone,
//                    String originalMail, String file, String describe, Long userId) {
//        this.title = title;
//        this.fieldId = fieldId;
//        this.nodeId = nodeId;
//        this.phone = phone;
//        this.eventId = eventId;
//        this.influence = influence;
//        this.urgent = urgent;
//        this.original = original;
//        this.originalMobile = originalMobile;
//        this.originalPhone = originalPhone;
//        this.originalMail = originalMail;
//        this.file = file;
//        this.describe = describe;
//        this.userId = userId;
//    }
//
//    public Question(Long id, String title, Long fieldId, Long nodeId, String phone, Integer eventId, Integer influence,
//                    Integer urgent, String original, String originalMobile, String originalPhone,
//                    String originalMail, String file, String describe, Integer status, Long userId) {
//        this.id = id;
//        this.title = title;
//        this.fieldId = fieldId;
//        this.nodeId = nodeId;
//        this.phone = phone;
//        this.eventId = eventId;
//        this.influence = influence;
//        this.urgent = urgent;
//        this.original = original;
//        this.originalMobile = originalMobile;
//        this.originalPhone = originalPhone;
//        this.originalMail = originalMail;
//        this.file = file;
//        this.describe = describe;
//        this.status = status;
//        this.userId = userId;
//    }

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

    public Long getNodeId() {
        return nodeId;
    }

    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public Integer getInfluence() {
        return influence;
    }

    public void setInfluence(Integer influence) {
        this.influence = influence;
    }

    public Integer getUrgent() {
        return urgent;
    }

    public void setUrgent(Integer urgent) {
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

    public String getStrTime() {
        return strTime;
    }

    public void setStrTime(String strTime) {
        this.strTime = strTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}