package com.czyl.service;

import com.czyl.dto.CompanyDto;
import com.czyl.entity.Company;

import java.util.List;

/**
 * Created by liaozuyao on 2018/1/3.
 */
public interface CompanyService {

    Integer insertCompany(Company company);

    Integer updateCompany(Company company);

    List<Company> selectCompany();

    List<Company> selectCompanyById(Long id);
}
