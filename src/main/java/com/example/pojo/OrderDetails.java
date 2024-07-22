package com.example.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderDetails {
    @JsonProperty("orderId")
    private String orderId;
    @JsonProperty("origin")
    private String origin;

    public OrderDetails() {
    }

    public OrderDetails(String orderId, String origin) {
        this.orderId = orderId;
        this.origin = origin;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "orderId='" + orderId + '\'' +
                ", origin='" + origin + '\'' +
                '}';
    }
}
