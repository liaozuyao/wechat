package com.czyl.service.impl;

import com.czyl.dao.CompanyMapper;
import com.czyl.entity.Company;
import com.czyl.service.CompanyService;
import com.czyl.utils.Tools;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liaozuyao on 2018/1/3.
 */
@Service
public class CompanyServiceImpl implements CompanyService{

    @Resource
    private CompanyMapper companyMapper;

    public Integer insertCompany(String name) {
        Company company = new Company();
        company.setComName(name);
        company.setCreateTime(Tools.dateToString(Tools.getTimeMillis()));
        return companyMapper.insertCompany(company);
    }

    private List<Company> changeType(List<Company> companyList){
        List<Company> list = new ArrayList<Company>();
        for (Company company : companyList) {
            company.setStrTime(Tools.dateObjectToString(company.getCreateTime()));
            list.add(company);
        }
        return list;
    }

    public List<Company> getAllCompany() {
        return changeType(companyMapper.getAllCompany());
    }

    public Integer countCompany() {
        return companyMapper.countCompany();
    }

    public Integer deleteCompany(Long id, Integer status) {
        return companyMapper.changeCompanyStatus(id, status);
    }

    public List<Company> getAllNotDel() {
        return companyMapper.getAllNotDel();
    }

    public Integer changeCompanyName(String companyName, Long id) {
        return companyMapper.changeCompanyName(companyName, id);
    }
}
