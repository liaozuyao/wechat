package com.czyl.dao;

import com.czyl.entity.Company;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by liaozuyao on 2018/1/3.
 */
public interface CompanyMapper {

    Integer insertCompany(String name);

    Integer updateCompany(@Param("code") String code, @Param("name") String name, @Param("contactPhone") String contactPhone, @Param("contactMail") String contactMail, @Param("id") Long id);

    List<Company> selectCompany();

    Company selectCompanyById(Long id);
}
