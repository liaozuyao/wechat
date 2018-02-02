package com.czyl.entity;

/**
 * Created by liaozuyao on 2017/12/21.
 */
public class ChangeList extends BaseEntity {

    private String title;
    private Integer changeItem;
    private Integer changeClass;
    private Long changeCompany;
    private String changeApplicant;
    private String file;
    private String changeReason;
    private String changeContent;
    private Long userId;

//    public ChangeList(String title, Integer changeItem, Integer changeClass, Long changeApplicant, String file, String changeReason, String changeContent) {
//        this.title = title;
//        this.changeItem = changeItem;
//        this.changeClass = changeClass;
//        this.changeApplicant = changeApplicant;
//        this.file = file;
//        this.changeReason = changeReason;
//        this.changeContent = changeContent;
//    }

    public Long getChangeCompany() {
        return changeCompany;
    }

    public void setChangeCompany(Long changeCompany) {
        this.changeCompany = changeCompany;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getChangeItem() {
        return changeItem;
    }

    public void setChangeItem(Integer changeItem) {
        this.changeItem = changeItem;
    }

    public Integer getChangeClass() {
        return changeClass;
    }

    public void setChangeClass(Integer changeClass) {
        this.changeClass = changeClass;
    }

    public String getChangeApplicant() {
        return changeApplicant;
    }

    public void setChangeApplicant(String changeApplicant) {
        this.changeApplicant = changeApplicant;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getChangeReason() {
        return changeReason;
    }

    public void setChangeReason(String changeReason) {
        this.changeReason = changeReason;
    }

    public String getChangeContent() {
        return changeContent;
    }

    public void setChangeContent(String changeContent) {
        this.changeContent = changeContent;
    }

}
