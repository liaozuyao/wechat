package com.czyl.service;

import com.czyl.entity.Urgent;

import java.util.List;

public interface UrgentService {

    List<Urgent> getAllUrgent();

    Integer deleteUrgent(Long id);

    Integer insertUrgent(String name);
}
