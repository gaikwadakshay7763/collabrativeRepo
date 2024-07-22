package com.example.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CvcAddressResult {
    @JsonProperty("postCode")
    private String postCode;
    @JsonProperty("address")
    private String address;
    @JsonProperty("cvc")
    private String cvc;

    public CvcAddressResult() {
    }

    public CvcAddressResult(String postCode, String address, String cvc) {
        this.postCode = postCode;
        this.address = address;
        this.cvc = cvc;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    @Override
    public String toString() {
        return "CvcAddressResult{" +
                "postCode='" + postCode + '\'' +
                ", address='" + address + '\'' +
                ", cvc='" + cvc + '\'' +
                '}';
    }
}
