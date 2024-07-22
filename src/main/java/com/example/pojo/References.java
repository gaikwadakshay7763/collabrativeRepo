package com.example.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class References {
    @JsonProperty("paymentPlatform")
    private String paymentPlatform;
    @JsonProperty("transactionId")
    private String transactionId;

    public References() {
    }

    public References(String paymentPlatform, String transactionId) {
        this.paymentPlatform = paymentPlatform;
        this.transactionId = transactionId;
    }

    public String getPaymentPlatform() {
        return paymentPlatform;
    }

    public void setPaymentPlatform(String paymentPlatform) {
        this.paymentPlatform = paymentPlatform;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    @Override
    public String toString() {
        return "References{" +
                "paymentPlatform='" + paymentPlatform + '\'' +
                ", transactionId='" + transactionId + '\'' +
                '}';
    }
}
