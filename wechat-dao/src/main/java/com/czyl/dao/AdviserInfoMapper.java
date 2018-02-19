package com.czyl.dao;

import com.czyl.entity.AdviserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdviserInfoMapper {

    Integer insertAdviserInfo(AdviserInfo adviserInfo);

    List<AdviserInfo> getAllAdviser();

    Integer updateAdviserInfo(AdviserInfo adviserInfo);

    AdviserInfo adviserOrDevlpLogin(@Param("phone")String phone, @Param("password")String password);

    List<AdviserInfo> getAllByType(Integer type);
}
