package com.czyl.service;

import com.czyl.entity.Company;

import java.util.List;

/**
 * Created by liaozuyao on 2018/1/3.
 */
public interface CompanyService {

    Integer insertCompany(String name);

    List<Company> getAllCompany();

    Integer countCompany();

    Integer deleteCompany(Long id, Integer status);

    List<Company> getAllNotDel();

    Integer changeCompanyName(String companyName, Long id);
}
