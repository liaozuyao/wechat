package com.czyl.dao;

import com.czyl.entity.Urgent;

import java.util.List;

public interface UrgentMapper {

    List<Urgent> getAllUrgent();

    Integer deleteUrgent(Long id);

    Integer insertUrgent(String name);

    String getNameById(Long id);
}
