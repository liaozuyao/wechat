package com.czyl.service;

import com.czyl.entity.AdviserInfo;

import java.util.List;

public interface AdviserInfoService {

    Integer insertAdviserInfo(String name, String phone, String mail, Integer type);

    List<AdviserInfo> getAllAdviser();

    Integer updateAdviserInfo(String name, String phone, String mail, Long id, Integer type);
}
