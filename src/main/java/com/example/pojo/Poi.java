package com.example.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Poi {
    @JsonProperty("terminalIds")
    private List<String> terminalIds;
    @JsonProperty("country")
    private String country;
    @JsonProperty("terminalCapabilities")
    private TerminalCapabilities terminalCapabilities;

    public Poi() {
    }

    public Poi(List<String> terminalIds, String country, TerminalCapabilities terminalCapabilities) {
        this.terminalIds = terminalIds;
        this.country = country;
        this.terminalCapabilities = terminalCapabilities;
    }

    public List<String> getTerminalIds() {
        return terminalIds;
    }

    public void setTerminalIds(List<String> terminalIds) {
        this.terminalIds = terminalIds;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public TerminalCapabilities getTerminalCapabilities() {
        return terminalCapabilities;
    }

    public void setTerminalCapabilities(TerminalCapabilities terminalCapabilities) {
        this.terminalCapabilities = terminalCapabilities;
    }

    @Override
    public String toString() {
        return "Poi{" +
                "terminalIds=" + terminalIds +
                ", country='" + country + '\'' +
                ", terminalCapabilities=" + terminalCapabilities +
                '}';
    }
}
