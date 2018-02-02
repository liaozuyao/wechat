package com.czyl.dao;

import com.czyl.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by liaozuyao on 2018/1/2.
 */
public interface UserMapper {

    Integer insertUser(User user);

    User selectUserExist(@Param("openId") String openId);
}
