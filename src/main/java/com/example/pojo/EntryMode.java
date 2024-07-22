package com.example.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EntryMode {
    @JsonProperty("fallbackindicator")
    private boolean fallbackindicator;
    @JsonProperty("entryMode")
    private String entryMode;

    public EntryMode() {
    }

    public EntryMode(boolean fallbackindicator, String entryMode) {
        this.fallbackindicator = fallbackindicator;
        this.entryMode = entryMode;
    }

    public boolean isFallbackindicator() {
        return fallbackindicator;
    }

    public void setFallbackindicator(boolean fallbackindicator) {
        this.fallbackindicator = fallbackindicator;
    }

    public String getEntryMode() {
        return entryMode;
    }

    public void setEntryMode(String entryMode) {
        this.entryMode = entryMode;
    }

    @Override
    public String toString() {
        return "EntryMode{" +
                "fallbackindicator=" + fallbackindicator +
                ", entryMode='" + entryMode + '\'' +
                '}';
    }
}
