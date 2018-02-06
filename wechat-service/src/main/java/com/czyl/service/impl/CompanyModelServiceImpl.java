package com.czyl.service.impl;

import com.czyl.dao.CompanyModelMapper;
import com.czyl.entity.CompanyModel;
import com.czyl.service.CompanyModelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CompanyModelServiceImpl implements CompanyModelService{

    @Resource
    CompanyModelMapper companyModelMapper;

    public Integer insertCompanyModel(CompanyModel companyModel) {
        return companyModelMapper.insertCompanyModel(companyModel);
    }

    public List<CompanyModel> selectAll() {
        return companyModelMapper.selectAll();
    }

    public List<CompanyModel> selectByCompanyId(Long companyId) {
        return companyModelMapper.selectByCompanyId(companyId);
    }
}
