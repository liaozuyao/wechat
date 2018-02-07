package com.czyl.service;

import com.czyl.entity.CompanyInfo;

import java.util.List;

public interface CompanyInfoService {

    List<CompanyInfo> select(Long id);
}
