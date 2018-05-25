package com.czyl.service;

import com.czyl.bean.Company;

import java.util.List;

public interface ICompanyService {

    Integer addCompany(String name);

    Integer updateCompany(String code, String phone, String mail, Long id);

    Integer deleteCompany(Integer isdelete, Long id);

    List<Company> getAllCompany();
}
