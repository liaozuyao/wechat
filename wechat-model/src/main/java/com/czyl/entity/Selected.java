package com.czyl.entity;

/**
 * Created by liaozuyao on 2017/12/19.
 */
public class Selected extends BaseEntity{

    private String name;
    private long parentId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }
}
