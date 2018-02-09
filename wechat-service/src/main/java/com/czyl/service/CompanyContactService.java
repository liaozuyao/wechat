package com.czyl.service;

import com.czyl.entity.CompanyContact;

public interface CompanyContactService {

    Integer insertCompanyContact(String account, Long companyId);

    Integer updateCompanyContact(String name, String phone, String mail, Long id);

    Integer updateCompanyContactPassword(String password, Long id);

    Integer updateAccountIsActive(Integer isActive, Long id);

    Integer updateAccountIsSuper(Integer isSuper, Long id);

    CompanyContact selectCompanyContact(String account, String password);
}
