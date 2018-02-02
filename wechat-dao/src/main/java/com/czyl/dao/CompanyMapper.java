package com.czyl.dao;

import com.czyl.entity.Company;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by liaozuyao on 2018/1/3.
 */
public interface CompanyMapper {

    Integer insertCompany(Company company);

    List<Company> getAllCompany();

    Integer countCompany();

    Integer changeCompanyStatus(@Param("id") Long id, @Param("isDel") Integer status);

    List<Company> getAllNotDel();

    Integer changeCompanyName(@Param("companyName") String companyName, @Param("id") Long id);
}
