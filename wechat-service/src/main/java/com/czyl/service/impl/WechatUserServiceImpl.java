package com.czyl.service.impl;

import com.czyl.bean.WechatUser;
import com.czyl.dao.IWechatUserMapper;
import com.czyl.service.IWechatUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class WechatUserServiceImpl implements IWechatUserService{

    @Resource
    private IWechatUserMapper iWechatUserMapper;

    public Integer addWechatUser(String openId, String userName, String imgStr) {
        return iWechatUserMapper.addWechatUser(openId, userName, imgStr);
    }

    public Integer relationUserCompnay(Long id, Long companyId) {
        return iWechatUserMapper.relationUserCompnay(id, companyId);
    }

    public List<WechatUser> getAllUser() {
        return iWechatUserMapper.getAllUser();
    }

    public Integer updateUserInfo(String opendId, String userName, String imgStr) {
        return iWechatUserMapper.updateUserInfo(opendId, userName, imgStr);
    }

    public Integer cancelRelation(Long id) {
        return iWechatUserMapper.cancelRelation(id);
    }

    public Integer updateDelete(Long id, Integer isdelete) {
        return iWechatUserMapper.updateDelete(id, isdelete);
    }
}
