package com.czyl.service.impl;

import com.czyl.dao.CompanyInfoMapper;
import com.czyl.entity.CompanyInfo;
import com.czyl.service.CompanyInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CompanyInfoServiceImpl implements CompanyInfoService{

    @Resource
    CompanyInfoMapper companyInfoMapper;

    public List<CompanyInfo> select(Long id) {
        return companyInfoMapper.select(id);
    }
}
