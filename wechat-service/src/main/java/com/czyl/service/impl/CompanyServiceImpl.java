package com.czyl.service.impl;

import com.czyl.common.Constants;
import com.czyl.dao.CompanyMapper;
import com.czyl.dto.CompanyDto;
import com.czyl.entity.Company;
import com.czyl.service.CompanyService;
import com.czyl.utils.MD5Utils;
import com.czyl.utils.Tools;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liaozuyao on 2018/1/3.
 */
@Service
public class CompanyServiceImpl implements CompanyService {

    @Resource
    private CompanyMapper companyMapper;

    public Integer insertCompany(String name) {
        return companyMapper.insertCompany(name);
    }

    public Integer updateCompany(String code, String name, String contactPhone, String contactMail, Long id) {
        return companyMapper.updateCompany(code, name, contactPhone, contactMail, id);
    }

    public List<Company> selectCompany() {
        return companyMapper.selectCompany();
    }

    public Company selectCompanyById(Long id) {
        return companyMapper.selectCompanyById(id);
    }

}
