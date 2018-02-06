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
    ServiceModelMapper serviceModelMapper;

    public Integer insert(ServiceModel serviceModel) {
        return serviceModelMapper.insert(serviceModel);
    }

    public List<ServiceModel> selectServiceName() {
        return serviceModelMapper.selectServiceName();
    }
}
