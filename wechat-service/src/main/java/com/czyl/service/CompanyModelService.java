package com.czyl.service;

import com.czyl.entity.CompanyModel;

import java.util.List;

public interface CompanyModelService {

    Integer insertCompanyModel(CompanyModel companyModel);

    List<CompanyModel> selectAll();

    List<CompanyModel> selectByCompanyId(Long companyId);
}
