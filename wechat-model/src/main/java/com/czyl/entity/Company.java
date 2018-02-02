package com.czyl.entity;

import java.util.Date;

/**
 * Created by liaozuyao on 2018/1/3.
 */
public class Company extends BaseEntity {

    private String comName;
    private Date createTime;
    private String strTime;
    private Integer isDelete;

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getStrTime() {
        return strTime;
    }

    public void setStrTime(String strTime) {
        this.strTime = strTime;
    }

    public String getComName() {
        return comName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }
}
