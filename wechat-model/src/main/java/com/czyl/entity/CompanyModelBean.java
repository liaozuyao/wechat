package com.czyl.entity;

public class CompanyModelBean {

    private Long companyId;
    private Long serviceId;
    private String enclosure;
    private String companyName;
    private String modelName;
//    private Company company;
//    private ServiceModel serviceModel;

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

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

//    public Company getCompany() {
//        return company;
//    }
//
//    public void setCompany(Company company) {
//        this.company = company;
//    }
//
//    public ServiceModel getServiceModel() {
//        return serviceModel;
//    }
//
//    public void setServiceModel(ServiceModel serviceModel) {
//        this.serviceModel = serviceModel;
//    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
}
