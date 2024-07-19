package com.example.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Card {
    @JsonProperty("brand")
    private String brand;
    @JsonProperty("pan")
    private String pan;
    @JsonProperty("entryMode")
    private EntryMode entryMode;
    @JsonProperty("cvcPresence")
    private String cvcPresence;
    @JsonProperty("expiryDate")
    private ExpiryDate expiryDate;
    @JsonProperty("isPresent")
    private boolean isPresent;

    public Card() {
    }

    public Card(String brand, String pan, EntryMode entryMode, String cvcPresence, ExpiryDate expiryDate, boolean isPresent) {
        this.brand = brand;
        this.pan = pan;
        this.entryMode = entryMode;
        this.cvcPresence = cvcPresence;
        this.expiryDate = expiryDate;
        this.isPresent = isPresent;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public EntryMode getEntryMode() {
        return entryMode;
    }

    public void setEntryMode(EntryMode entryMode) {
        this.entryMode = entryMode;
    }

    public String getCvcPresence() {
        return cvcPresence;
    }

    public void setCvcPresence(String cvcPresence) {
        this.cvcPresence = cvcPresence;
    }

    public ExpiryDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(ExpiryDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public boolean isPresent() {
        return isPresent;
    }

    public void setPresent(boolean present) {
        isPresent = present;
    }

    @Override
    public String toString() {
        return "Card{" +
                "brand='" + brand + '\'' +
                ", pan='" + pan + '\'' +
                ", entryMode=" + entryMode +
                ", cvcPresence='" + cvcPresence + '\'' +
                ", expiryDate=" + expiryDate +
                ", isPresent=" + isPresent +
                '}';
    }
}
