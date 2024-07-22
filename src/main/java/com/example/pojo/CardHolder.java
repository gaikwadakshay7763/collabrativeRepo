package com.example.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CardHolder {
    @JsonProperty("verifyMethod")
    private String verifyMethod;
    @JsonProperty("isPresent")
    private boolean isPresent;

    public CardHolder() {
    }

    public CardHolder(String verifyMethod, boolean isPresent) {
        this.verifyMethod = verifyMethod;
        this.isPresent = isPresent;
    }

    public String getVerifyMethod() {
        return verifyMethod;
    }

    public void setVerifyMethod(String verifyMethod) {
        this.verifyMethod = verifyMethod;
    }

    public boolean isPresent() {
        return isPresent;
    }

    public void setPresent(boolean present) {
        isPresent = present;
    }

    @Override
    public String toString() {
        return "CardHolder{" +
                "verifyMethod='" + verifyMethod + '\'' +
                ", isPresent=" + isPresent +
                '}';
    }
}
