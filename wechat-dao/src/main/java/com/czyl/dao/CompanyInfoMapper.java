package com.czyl.dao;

import com.czyl.entity.CompanyInfo;

import java.util.List;

public interface CompanyInfoMapper {

    List<CompanyInfo> select(Long id);
}
