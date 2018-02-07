package com.czyl.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyModelMapper {

    Integer insertCompanyModel(@Param("companyId") Long companyId, @Param("serviceId") Long modelId, @Param("enclosure") String enclosure);
}
