package com.czyl.dao;

import com.czyl.entity.CompanyContact;
import org.apache.ibatis.annotations.Param;

public interface CompanyContactMapper {

    Integer insertCompanyContact(@Param("companyId")Long companyId,@Param("account")String account,
                                 @Param("password")String password);

    Integer updateCompanyContact(@Param("name")String name,@Param("phone")String phone,@Param("mail")String mail,@Param("id")Long id);

    Integer updateCompanyContactPassword(@Param("password")String password, @Param("id")Long id);

    Integer updateAccountIsActive(@Param("isActive")Integer isActive, @Param("id")Long id);

    Integer updateAccountIsSuper(@Param("isSuper")Integer isSuper,@Param("id")Long id);

    CompanyContact selectCompanyContact(@Param("account")String account, @Param("password")String password);

    CompanyContact selectCompanyContactById(Long id);
}
