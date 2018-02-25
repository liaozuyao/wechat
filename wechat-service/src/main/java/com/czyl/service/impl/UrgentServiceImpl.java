package com.czyl.service.impl;

import com.czyl.dao.UrgentMapper;
import com.czyl.entity.Urgent;
import com.czyl.service.UrgentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UrgentServiceImpl implements UrgentService{

    @Resource
    private UrgentMapper urgentMapper;

    public List<Urgent> getAllUrgent() {
        return urgentMapper.getAllUrgent();
    }

    public Integer deleteUrgent(Long id) {
        return urgentMapper.deleteUrgent(id);
    }

    public Integer insertUrgent(String name) {
        return urgentMapper.insertUrgent(name);
    }

    public String getNameById(Long id) {
        return urgentMapper.getNameById(id);
    }
}
