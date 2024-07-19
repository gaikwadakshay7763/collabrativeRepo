package com.example.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExpiryDate {
    @JsonProperty("year")
    private String year;
    @JsonProperty("month")
    private String month;

    public ExpiryDate() {
    }

    public ExpiryDate(String year, String month) {
        this.year = year;
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return "ExpiryDate{" +
                "year='" + year + '\'' +
                ", month='" + month + '\'' +
                '}';
    }
}
