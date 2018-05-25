package com.czyl.service.impl;

import com.czyl.dao.ICompanyMapper;
import com.czyl.service.ICompanyService;
import com.czyl.bean.Company;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CompanyServiceImpl implements ICompanyService{

    @Resource
    private ICompanyMapper iCompanyMapper;

    public Integer addCompany(String name) {
        return iCompanyMapper.addCompany(name);
    }

    public Integer updateCompany(String code, String phone, String mail, Long id) {
        return iCompanyMapper.updateCompany(code, phone, mail, id);
    }

    public Integer deleteCompany(Integer isdelete, Long id) {
        return iCompanyMapper.deleteCompany(isdelete, id);
    }

    public List<Company> getAllCompany() {
        return iCompanyMapper.getAllCompany();
    }

}
