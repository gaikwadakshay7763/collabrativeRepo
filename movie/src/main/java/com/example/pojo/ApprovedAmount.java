package com.example.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApprovedAmount {
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("amount")
    private double amount;

    public ApprovedAmount() {
    }

    public ApprovedAmount(String currency, double amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "ApprovedAmount{" +
                "currency='" + currency + '\'' +
                ", amount=" + amount +
                '}';
    }
}
