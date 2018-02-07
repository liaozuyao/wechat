package com.czyl.entity;

/**
 * 合同模块
 */
public class CompanyModel{

    private Long companyId;
    private Long serviceId;
    private String enclosure;

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(String enclosure) {
        this.enclosure = enclosure;
    }

    public Long getCompanyId() {

        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }
}
