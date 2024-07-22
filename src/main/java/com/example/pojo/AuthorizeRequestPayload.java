package com.example.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthorizeRequestPayload{

        @JsonProperty("authorizeRequestBase")
        private AuthorizeRequestBase authorizeRequestBase;

        @JsonProperty("maxWaitTime")
        private int maxWaitTime;

        // Getters and setters...

        public AuthorizeRequestBase getAuthorizeRequestBase() {
            return authorizeRequestBase;
        }

        public void setAuthorizeRequestBase(AuthorizeRequestBase authorizeRequestBase) {
            this.authorizeRequestBase = authorizeRequestBase;
        }

        public int getMaxWaitTime() {
            return maxWaitTime;
        }

        public void setMaxWaitTime(int maxWaitTime) {
            this.maxWaitTime = maxWaitTime;
        }
    }


