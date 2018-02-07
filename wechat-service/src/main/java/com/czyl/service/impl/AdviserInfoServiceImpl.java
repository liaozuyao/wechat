package com.czyl.service.impl;

import com.czyl.dao.AdviserInfoMapper;
import com.czyl.entity.AdviserInfo;
import com.czyl.service.AdviserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdviserInfoServiceImpl implements AdviserInfoService{

    @Resource
    AdviserInfoMapper adviserInfoMapper;

    public Integer insertAdviserInfo(AdviserInfo adviserInfo) {
        return adviserInfoMapper.insertAdviserInfo(adviserInfo);
    }

    public List<AdviserInfo> getAllAdviser() {
        return adviserInfoMapper.getAllAdviser();
    }
}
