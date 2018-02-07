package com.czyl.dao;

import com.czyl.entity.ServiceModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ServiceModelMapper {

    Integer insert(String name);

    List<ServiceModel> selectServiceName();

    Integer updateServiceName(@Param("name") String name, @Param("id") Long id);

    Integer deleteServiceName(@Param("isDelete") Integer isDelete, @Param("id") Long id);
}
