package com.czyl.service;

import com.czyl.entity.AdviserInfo;

import java.util.List;

public interface AdviserInfoService {

    Integer insertAdviserInfo(AdviserInfo adviserInfo);

    List<AdviserInfo> getAllAdviser();
}
