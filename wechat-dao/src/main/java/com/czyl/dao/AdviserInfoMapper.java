package com.czyl.dao;

import com.czyl.entity.AdviserInfo;

import java.util.List;

public interface AdviserInfoMapper {

    Integer insertAdviserInfo(AdviserInfo adviserInfo);

    List<AdviserInfo> getAllAdviser();

    Integer updateAdviserInfo(AdviserInfo adviserInfo);
}
