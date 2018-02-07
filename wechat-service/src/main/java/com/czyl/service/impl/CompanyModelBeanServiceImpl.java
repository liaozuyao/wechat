package com.czyl.service.impl;

import com.czyl.dao.CompanyModelBeanMapper;
import com.czyl.entity.CompanyModelBean;
import com.czyl.service.CompanyModelBeanService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CompanyModelBeanServiceImpl implements CompanyModelBeanService{

    @Resource
    CompanyModelBeanMapper companyModelBeanMapper;

    public List<CompanyModelBean> selectByCompanyId(Long id) {
        return companyModelBeanMapper.selectByCompanyId(id);
    }

    public List<CompanyModelBean> selectAllCompany() {
        return companyModelBeanMapper.selectAllCompany();
    }
}
