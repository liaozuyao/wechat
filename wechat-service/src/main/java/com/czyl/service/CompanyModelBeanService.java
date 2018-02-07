package com.czyl.service;

import com.czyl.entity.CompanyModelBean;

import java.util.List;

public interface CompanyModelBeanService {

    List<CompanyModelBean> selectByCompanyId(Long id);

    List<CompanyModelBean> selectAllCompany();
}
