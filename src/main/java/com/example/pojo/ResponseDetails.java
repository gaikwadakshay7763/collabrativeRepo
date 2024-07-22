package com.example.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class ResponseDetails {
    @JsonProperty("authorizationEntity")
    private String authorizationEntity;
    @JsonProperty("transTime")
    private String transTime;
    @JsonProperty("approvedAmount")
    private ApprovedAmount approvedAmount;
    @JsonProperty("transactionReferenceSent")
    private String transactionReferenceSent;
    @JsonProperty("acceptorReferenceUsed")
    private String acceptorReferenceUsed;
    @JsonProperty("terminalUsed")
    private String terminalUsed;
    @JsonProperty("captureRequired")
    private boolean  captureRequired;
    @JsonProperty("authType")
    private String authType;
    @JsonProperty("specificAcquirerData")
    private Map<?,?> specificAcquirerData;

    public ResponseDetails() {
    }

    public ResponseDetails(String authorizationEntity, String transTime, ApprovedAmount approvedAmount, String transactionReferenceSent, String acceptorReferenceUsed, String terminalUsed, boolean captureRequired, String authType, Map<?, ?> specificAcquirerData) {
        this.authorizationEntity = authorizationEntity;
        this.transTime = transTime;
        this.approvedAmount = approvedAmount;
        this.transactionReferenceSent = transactionReferenceSent;
        this.acceptorReferenceUsed = acceptorReferenceUsed;
        this.terminalUsed = terminalUsed;
        this.captureRequired = captureRequired;
        this.authType = authType;
        this.specificAcquirerData = specificAcquirerData;
    }

    public String getAuthorizationEntity() {
        return authorizationEntity;
    }

    public void setAuthorizationEntity(String authorizationEntity) {
        this.authorizationEntity = authorizationEntity;
    }

    public String getTransTime() {
        return transTime;
    }

    public void setTransTime(String transTime) {
        this.transTime = transTime;
    }

    public ApprovedAmount getApprovedAmount() {
        return approvedAmount;
    }

    public void setApprovedAmount(ApprovedAmount approvedAmount) {
        this.approvedAmount = approvedAmount;
    }

    public String getTransactionReferenceSent() {
        return transactionReferenceSent;
    }

    public void setTransactionReferenceSent(String transactionReferenceSent) {
        this.transactionReferenceSent = transactionReferenceSent;
    }

    public String getAcceptorReferenceUsed() {
        return acceptorReferenceUsed;
    }

    public void setAcceptorReferenceUsed(String acceptorReferenceUsed) {
        this.acceptorReferenceUsed = acceptorReferenceUsed;
    }

    public String getTerminalUsed() {
        return terminalUsed;
    }

    public void setTerminalUsed(String terminalUsed) {
        this.terminalUsed = terminalUsed;
    }

    public boolean isCaptureRequired() {
        return captureRequired;
    }

    public void setCaptureRequired(boolean captureRequired) {
        this.captureRequired = captureRequired;
    }

    public String getAuthType() {
        return authType;
    }

    public void setAuthType(String authType) {
        this.authType = authType;
    }

    public Map<?, ?> getSpecificAcquirerData() {
        return specificAcquirerData;
    }

    public void setSpecificAcquirerData(Map<?, ?> specificAcquirerData) {
        this.specificAcquirerData = specificAcquirerData;
    }

    @Override
    public String toString() {
        return "ResponseDetails{" +
                "authorizationEntity='" + authorizationEntity + '\'' +
                ", transTime='" + transTime + '\'' +
                ", approvedAmount=" + approvedAmount +
                ", transactionReferenceSent='" + transactionReferenceSent + '\'' +
                ", acceptorReferenceUsed='" + acceptorReferenceUsed + '\'' +
                ", terminalUsed='" + terminalUsed + '\'' +
                ", captureRequired=" + captureRequired +
                ", authType='" + authType + '\'' +
                ", specificAcquirerData=" + specificAcquirerData +
                '}';
    }
}
