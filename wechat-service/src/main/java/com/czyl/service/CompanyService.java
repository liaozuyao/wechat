package com.czyl.service;

import com.czyl.entity.Company;

import java.util.List;

/**
 * Created by liaozuyao on 2018/1/3.
 */
public interface CompanyService {

    Integer insertCompany(String name);

    Integer updateCompany(String code, String name, String contactPhone, String contactMail, Long id);

    List<Company> selectCompany();

    Company selectCompanyById(Long id);
}
