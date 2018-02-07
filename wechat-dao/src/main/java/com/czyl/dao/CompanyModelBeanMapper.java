package com.czyl.dao;

import com.czyl.entity.CompanyModelBean;

import java.util.List;

public interface CompanyModelBeanMapper {

    List<CompanyModelBean> selectByCompanyId(Long id);

    List<CompanyModelBean> selectAllCompany();
}
