package com.czyl.dao;

import com.czyl.entity.ServiceModel;

import java.util.List;

public interface ServiceModelMapper {

    Integer insert(ServiceModel serviceModel);

    List<ServiceModel> selectServiceName();
}
