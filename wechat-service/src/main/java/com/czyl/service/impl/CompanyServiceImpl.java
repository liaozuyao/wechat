package com.czyl.service.impl;

import com.czyl.dao.CompanyMapper;
import com.czyl.dto.CompanyDto;
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

    public Integer insertCompany(Company company) {
        return companyMapper.insertCompany(company);
    }

    public Integer updateCompany(Company company) {
        return companyMapper.updateCompany(company);
    }

    public List<Company> selectCompany() {
//        for (CompanyDto c:companyMapper.selectCompany()) {
//            System.out.println(c.toString());
//        }
        return companyMapper.selectCompany();
    }

    public List<Company> selectCompanyById(Long id) {
        return companyMapper.selectCompanyById(id);
    }

}
