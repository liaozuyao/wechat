package com.czyl.service;

import com.czyl.bean.WechatUser;

import java.util.List;

public interface IWechatUserService {

    Integer addWechatUser(String openId, String userName, String imgStr);

    Integer relationUserCompnay(Long id, Long companyId);

    List<WechatUser> getAllUser();

    Integer updateUserInfo(String opendId, String userName, String imgStr);

    Integer cancelRelation(Long id);

    Integer updateDelete(Long id, Integer isdelete);
}
