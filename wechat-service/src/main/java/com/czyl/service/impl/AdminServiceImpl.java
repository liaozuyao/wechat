package com.czyl.service.impl;

import com.czyl.dao.AdminMapper;
import com.czyl.entity.Admin;
import com.czyl.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminServiceImpl implements AdminService{

    @Resource
    private AdminMapper adminMapper;

    public Admin select(String name, String password) {
        return adminMapper.select(name, password);
    }
}
