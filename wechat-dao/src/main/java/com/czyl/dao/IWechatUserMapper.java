package com.czyl.dao;

import com.czyl.bean.WechatUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IWechatUserMapper {

    Integer addWechatUser(@Param("openId") String openId, @Param("userName") String userName, @Param("imgStr") String imgStr);

    Integer relationUserCompnay(@Param("id") Long id, @Param("companyId") Long companyId);

    List<WechatUser> getAllUser();

    Integer updateUserInfo(@Param("openId") String opendId, @Param("userName") String userName, @Param("imgStr") String imgStr);

    Integer cancelRelation(@Param("id") Long id);

    Integer updateDelete(@Param("id") Long id, @Param("isdelete") Integer isdelete);
}
