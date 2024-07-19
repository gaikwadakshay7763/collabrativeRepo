package com.example.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MerchantInfo {
    @JsonProperty("merchantIdentification")
    private String merchantIdentification;
    @JsonProperty("merchantCategoryCode")
    private String merchantCategoryCode;
    @JsonProperty("address")
    private Address address;
    @JsonProperty("companyName")
    private String companyName;

    public MerchantInfo() {
    }

    public MerchantInfo(String merchantIdentification, String merchantCategoryCode, Address address, String companyName) {
        this.merchantIdentification = merchantIdentification;
        this.merchantCategoryCode = merchantCategoryCode;
        this.address = address;
        this.companyName = companyName;
    }

    public String getMerchantIdentification() {
        return merchantIdentification;
    }

    public void setMerchantIdentification(String merchantIdentification) {
        this.merchantIdentification = merchantIdentification;
    }

    public String getMerchantCategoryCode() {
        return merchantCategoryCode;
    }

    public void setMerchantCategoryCode(String merchantCategoryCode) {
        this.merchantCategoryCode = merchantCategoryCode;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "MerchantInfo{" +
                "merchantIdentification='" + merchantIdentification + '\'' +
                ", merchantCategoryCode='" + merchantCategoryCode + '\'' +
                ", address=" + address +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}
