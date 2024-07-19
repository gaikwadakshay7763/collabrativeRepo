package com.example.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OriginalTransaction {
    @JsonProperty("cvcAddressResult")
    private CvcAddressResult cvcAddressResult;
    @JsonProperty("approvalStatus")
    private String approvalStatus;
    @JsonProperty("responseDetails")
    private ResponseDetails responseDetails;
    @JsonProperty("selectedInstallment")
    private SelectedInstallment selectedInstallment;

    public OriginalTransaction() {
    }

    public OriginalTransaction(CvcAddressResult cvcAddressResult, String approvalStatus, ResponseDetails responseDetails, SelectedInstallment selectedInstallment) {
        this.cvcAddressResult = cvcAddressResult;
        this.approvalStatus = approvalStatus;
        this.responseDetails = responseDetails;
        this.selectedInstallment = selectedInstallment;
    }

    public CvcAddressResult getCvcAddressResult() {
        return cvcAddressResult;
    }

    public void setCvcAddressResult(CvcAddressResult cvcAddressResult) {
        this.cvcAddressResult = cvcAddressResult;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public ResponseDetails getResponseDetails() {
        return responseDetails;
    }

    public void setResponseDetails(ResponseDetails responseDetails) {
        this.responseDetails = responseDetails;
    }

    public SelectedInstallment getSelectedInstallment() {
        return selectedInstallment;
    }

    public void setSelectedInstallment(SelectedInstallment selectedInstallment) {
        this.selectedInstallment = selectedInstallment;
    }

    @Override
    public String toString() {
        return "OriginalTransaction{" +
                "cvcAddressResult=" + cvcAddressResult +
                ", approvalStatus='" + approvalStatus + '\'' +
                ", responseDetails=" + responseDetails +
                ", selectedInstallment=" + selectedInstallment +
                '}';
    }
}
