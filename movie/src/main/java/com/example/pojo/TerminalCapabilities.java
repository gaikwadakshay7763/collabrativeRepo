package com.example.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TerminalCapabilities {
    @JsonProperty("magstripeEntry")
    private boolean magstripeEntry;
    @JsonProperty("pkeEntry")
    private boolean pkeEntry;
    @JsonProperty("emvEntry")
    private boolean emvEntry;
    @JsonProperty("contactlessEntry")
    private boolean contactlessEntry;
    @JsonProperty("cvmPin")
    private boolean cvmPin;
    @JsonProperty("cvmSignature")
    private boolean cvmSignature;

    public TerminalCapabilities() {
    }

    public TerminalCapabilities(boolean magstripeEntry, boolean pkeEntry, boolean emvEntry, boolean contactlessEntry, boolean cvmPin, boolean cvmSignature) {
        this.magstripeEntry = magstripeEntry;
        this.pkeEntry = pkeEntry;
        this.emvEntry = emvEntry;
        this.contactlessEntry = contactlessEntry;
        this.cvmPin = cvmPin;
        this.cvmSignature = cvmSignature;
    }

    public boolean isMagstripeEntry() {
        return magstripeEntry;
    }

    public void setMagstripeEntry(boolean magstripeEntry) {
        this.magstripeEntry = magstripeEntry;
    }

    public boolean isPkeEntry() {
        return pkeEntry;
    }

    public void setPkeEntry(boolean pkeEntry) {
        this.pkeEntry = pkeEntry;
    }

    public boolean isEmvEntry() {
        return emvEntry;
    }

    public void setEmvEntry(boolean emvEntry) {
        this.emvEntry = emvEntry;
    }

    public boolean isContactlessEntry() {
        return contactlessEntry;
    }

    public void setContactlessEntry(boolean contactlessEntry) {
        this.contactlessEntry = contactlessEntry;
    }

    public boolean isCvmPin() {
        return cvmPin;
    }

    public void setCvmPin(boolean cvmPin) {
        this.cvmPin = cvmPin;
    }

    public boolean isCvmSignature() {
        return cvmSignature;
    }

    public void setCvmSignature(boolean cvmSignature) {
        this.cvmSignature = cvmSignature;
    }

    @Override
    public String toString() {
        return "TerminalCapabilities{" +
                "magstripeEntry=" + magstripeEntry +
                ", pkeEntry=" + pkeEntry +
                ", emvEntry=" + emvEntry +
                ", contactlessEntry=" + contactlessEntry +
                ", cvmPin=" + cvmPin +
                ", cvmSignature=" + cvmSignature +
                '}';
    }
}
