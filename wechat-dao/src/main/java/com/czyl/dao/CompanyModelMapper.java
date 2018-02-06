package com.czyl.dao;

import com.czyl.entity.CompanyModel;

import java.util.List;

public interface CompanyModelMapper {

    Integer insertCompanyModel(CompanyModel companyModel);

    List<CompanyModel> selectAll();

    List<CompanyModel> selectByCompanyId(Long companyId);
}
