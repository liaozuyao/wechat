package com.czyl.entity;

/**
 * Created by liaozuyao on 2018/1/2.
 */
public class User extends BaseEntity{

    private String openId;
    private String name;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "openId='" + openId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
