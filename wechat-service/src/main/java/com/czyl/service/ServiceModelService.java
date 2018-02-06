package com.czyl.service;

import com.czyl.entity.ServiceModel;

import java.util.List;

public interface ServiceModelService {

    Integer insert(ServiceModel serviceModel);

    List<ServiceModel> selectServiceName();
}
