package com.czyl.service.impl;

import com.czyl.common.Constants;
import com.czyl.dao.CompanyContactMapper;
import com.czyl.entity.CompanyContact;
import com.czyl.service.CompanyContactService;
import com.czyl.utils.MD5Utils;
import com.czyl.utils.Tools;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CompanyContactServiceImpl implements CompanyContactService{

    @Resource
    private CompanyContactMapper companyContactMapper;

    public Integer insertCompanyContact(String account, Long companyId) {
        String password = MD5Utils.EncoderByMd5(Constants.INIT_PASSWORD);
        return companyContactMapper.insertCompanyContact(companyId, account, password);
    }

    public Integer updateCompanyContact(String name, String phone, String mail, Long id) {
        return companyContactMapper.updateCompanyContact(name, phone, mail, id);
    }

    public Integer updateCompanyContactPassword(String password, Long id) {
        password = MD5Utils.EncoderByMd5(password);
        return companyContactMapper.updateCompanyContactPassword(password, id);
    }

    public Integer updateAccountIsActive(Integer isActive, Long id) {
        return companyContactMapper.updateAccountIsActive(isActive, id);
    }

    public Integer updateAccountIsSuper(Integer isSuper, Long id) {
        return companyContactMapper.updateAccountIsSuper(isSuper, id);
    }

    public CompanyContact selectCompanyContact(String account, String password) {
        return companyContactMapper.selectCompanyContact(account, password);
    }
}
