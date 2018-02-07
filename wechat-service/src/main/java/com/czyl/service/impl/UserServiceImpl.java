package com.czyl.service.impl;

import com.czyl.dao.UserMapper;
import com.czyl.entity.User;
import com.czyl.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by liaozuyao on 2018/1/2.
 */
@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserMapper userMapper;

    public Integer insertUser(User user) {
        return userMapper.insertUser(user);
    }

    public User selectUserExist(String openId) {
        return userMapper.selectUserExist(openId);
    }
}
