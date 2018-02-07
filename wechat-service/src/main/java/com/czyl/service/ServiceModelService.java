package com.czyl.service;

import com.czyl.entity.ServiceModel;

import java.util.List;

public interface ServiceModelService {

    Integer insert(String name);

    List<ServiceModel> selectServiceName();

    Integer updateServiceName(String name, Long id);

    Integer deleteServiceName(Integer isDelete, Long id);
}
