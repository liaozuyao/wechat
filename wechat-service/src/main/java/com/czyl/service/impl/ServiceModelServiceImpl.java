package com.czyl.service.impl;

import com.czyl.dao.ServiceModelMapper;
import com.czyl.entity.ServiceModel;
import com.czyl.service.ServiceModelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ServiceModelServiceImpl implements ServiceModelService{

    @Resource
    private ServiceModelMapper serviceModelMapper;

    public Integer insert(String name) {
        return serviceModelMapper.insert(name);
    }

    public List<ServiceModel> selectServiceName() {
        return serviceModelMapper.selectServiceName();
    }

    public Integer updateServiceName(String name, Long id) {
        return serviceModelMapper.updateServiceName(name, id);
    }

    public Integer deleteServiceName(Integer isDelete, Long id) {
        return serviceModelMapper.deleteServiceName(isDelete, id);
    }
}
