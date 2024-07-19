package com.example.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionDetails {
    @JsonProperty("transTime")
    private String transTime;
    @JsonProperty("localDateTime")
    private String localDateTime;
    @JsonProperty("onlineReason")
    private String onlineReason;
    @JsonProperty("attemptCounter")
    private int attemptCounter;
    @JsonProperty("fraudSuspected")
    private boolean fraudSuspected;
    @JsonProperty("amount")
    private Amount amount;
    @JsonProperty("transactionRef")
    private String transactionRef;
    @JsonProperty("acceptorReference")
    private String acceptorReference;
    @JsonProperty("dccRequested")
    private boolean dccRequested;
    @JsonProperty("chargeBackEligibility")
    private boolean chargeBackEligibility;
    @JsonProperty("parRequested")
    private boolean parRequested;

    public TransactionDetails() {
    }

    public TransactionDetails(String transTime, String localDateTime, String onlineReason, int attemptCounter, boolean fraudSuspected, Amount amount, String transactionRef, String acceptorReference, boolean dccRequested, boolean chargeBackEligibility, boolean parRequested) {
        this.transTime = transTime;
        this.localDateTime = localDateTime;
        this.onlineReason = onlineReason;
        this.attemptCounter = attemptCounter;
        this.fraudSuspected = fraudSuspected;
        this.amount = amount;
        this.transactionRef = transactionRef;
        this.acceptorReference = acceptorReference;
        this.dccRequested = dccRequested;
        this.chargeBackEligibility = chargeBackEligibility;
        this.parRequested = parRequested;
    }

    public String getTransTime() {
        return transTime;
    }

    public void setTransTime(String transTime) {
        this.transTime = transTime;
    }

    public String getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(String localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getOnlineReason() {
        return onlineReason;
    }

    public void setOnlineReason(String onlineReason) {
        this.onlineReason = onlineReason;
    }

    public int getAttemptCounter() {
        return attemptCounter;
    }

    public void setAttemptCounter(int attemptCounter) {
        this.attemptCounter = attemptCounter;
    }

    public boolean isFraudSuspected() {
        return fraudSuspected;
    }

    public void setFraudSuspected(boolean fraudSuspected) {
        this.fraudSuspected = fraudSuspected;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public String getTransactionRef() {
        return transactionRef;
    }

    public void setTransactionRef(String transactionRef) {
        this.transactionRef = transactionRef;
    }

    public String getAcceptorReference() {
        return acceptorReference;
    }

    public void setAcceptorReference(String acceptorReference) {
        this.acceptorReference = acceptorReference;
    }

    public boolean isDccRequested() {
        return dccRequested;
    }

    public void setDccRequested(boolean dccRequested) {
        this.dccRequested = dccRequested;
    }

    public boolean isChargeBackEligibility() {
        return chargeBackEligibility;
    }

    public void setChargeBackEligibility(boolean chargeBackEligibility) {
        this.chargeBackEligibility = chargeBackEligibility;
    }

    public boolean isParRequested() {
        return parRequested;
    }

    public void setParRequested(boolean parRequested) {
        this.parRequested = parRequested;
    }

    @Override
    public String toString() {
        return "TransactionDetails{" +
                "transTime='" + transTime + '\'' +
                ", localDateTime='" + localDateTime + '\'' +
                ", onlineReason='" + onlineReason + '\'' +
                ", attemptCounter=" + attemptCounter +
                ", fraudSuspected=" + fraudSuspected +
                ", amount=" + amount +
                ", transactionRef='" + transactionRef + '\'' +
                ", acceptorReference='" + acceptorReference + '\'' +
                ", dccRequested=" + dccRequested +
                ", chargeBackEligibility=" + chargeBackEligibility +
                ", parRequested=" + parRequested +
                '}';
    }
}
