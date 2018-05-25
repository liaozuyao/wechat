package com.czyl.dao;

import com.czyl.bean.Company;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ICompanyMapper {

    Integer addCompany(@Param("name") String name);

    Integer updateCompany(@Param("code") String code, @Param("phone") String phone, @Param("mail") String mail, @Param("id")Long id);

    Integer deleteCompany(@Param("isdelete")Integer isdelete, @Param("id") Long id);

    List<Company> getAllCompany();
}
