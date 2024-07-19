package com.example.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Header {
    @JsonProperty("requestId")
    private String requestId;
    @JsonProperty("references")
    private References references;

    public Header() {
    }

    public Header(String requestId, References references) {
        this.requestId = requestId;
        this.references = references;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public References getReferences() {
        return references;
    }

    public void setReferences(References references) {
        this.references = references;
    }

    @Override
    public String toString() {
        return "Header{" +
                "requestId='" + requestId + '\'' +
                ", references=" + references +
                '}';
    }
}
