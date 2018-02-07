package com.czyl.dao;

import com.czyl.entity.Company;

import java.util.List;

/**
 * Created by liaozuyao on 2018/1/3.
 */
public interface CompanyMapper {

    Integer insertCompany(Company company);

    Integer updateCompany(Company company);

    List<Company> selectCompany();

    List<Company> selectCompanyById(Long id);
}
