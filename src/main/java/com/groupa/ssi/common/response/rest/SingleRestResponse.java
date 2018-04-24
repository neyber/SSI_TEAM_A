package com.groupa.ssi.common.response.rest;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Miguel Rojas
 */
public class SingleRestResponse<T> extends RestResponse {

    private static final String TYPE = "SingleResponse";

    private final T content;

    public SingleRestResponse(T content) {
        super(TYPE);
        this.content = content;
    }

    @JsonProperty("data")
    public T getContent() {
        return this.content;
    }
}
