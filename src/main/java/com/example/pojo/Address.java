package com.example.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Address {
    @JsonProperty("addrLine1")
    private String addrLine1;
    @JsonProperty("city")
    private String city;
    @JsonProperty("country")
    private String country;
    @JsonProperty("postCode")
    private String postCode;

    public Address() {
    }

    public Address(String addrLine1, String city, String country, String postCode) {
        this.addrLine1 = addrLine1;
        this.city = city;
        this.country = country;
        this.postCode = postCode;
    }

    public String getAddrLine1() {
        return addrLine1;
    }

    public void setAddrLine1(String addrLine1) {
        this.addrLine1 = addrLine1;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addrLine1='" + addrLine1 + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", postCode='" + postCode + '\'' +
                '}';
    }
}
