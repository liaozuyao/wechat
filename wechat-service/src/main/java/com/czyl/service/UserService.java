package com.czyl.service;

import com.czyl.entity.User;

/**
 * Created by liaozuyao on 2018/1/2.
 */
public interface UserService {

    Integer insertUser(User user);

    User selectUserExist(String openId);
}
