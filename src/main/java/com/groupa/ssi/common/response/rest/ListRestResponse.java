package com.groupa.ssi.common.response.rest;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;
import java.util.Collections;

/**
 * @author Miguel Rojas
 */
public class ListRestResponse<T> extends RestResponse {
    private static final String TYPE = "ListResponse";

    private final Collection<T> content;

    public ListRestResponse(Collection<T> content) {
        super(TYPE);
        this.content = content;
    }

    @JsonProperty("data")
    public Collection<T> getContent() {
        return Collections.unmodifiableCollection(this.content);
    }
}
