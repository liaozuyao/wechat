package com.czyl.service.impl;

import com.czyl.dao.CompanyModelMapper;
import com.czyl.service.CompanyModelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CompanyModelServiceImpl implements CompanyModelService{

    @Resource
    private CompanyModelMapper companyModelMapper;

    public Integer insertCompanyModel(Long companyId, Long modelId, String enslosure) {
        return companyModelMapper.insertCompanyModel(companyId, modelId, enslosure);
    }
}
