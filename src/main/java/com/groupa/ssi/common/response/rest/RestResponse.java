package com.groupa.ssi.common.response.rest;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Miguel Rojas
 */
public abstract class RestResponse {
    private final String responseType;

    public RestResponse(String responseType) {
        this.responseType = responseType;
    }

    @JsonProperty("responseType")
    public String getResponseType() {
        return responseType;
    }
}
