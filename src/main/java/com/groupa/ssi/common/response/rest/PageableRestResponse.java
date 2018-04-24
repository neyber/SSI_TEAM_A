package com.groupa.ssi.common.response.rest;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;
import java.util.Collections;

/**
 * @author Miguel Rojas
 */
public class PageableRestResponse<T> extends RestResponse {

    private static final String TYPE = "PageableResponse";

    private final Collection<T> content;

    private final Long totalItems;

    private final Integer pageSize;

    private final Integer pageNumber;

    public PageableRestResponse(Collection<T> content, Long totalItems, Integer pageSize, Integer pageNumber) {
        super(TYPE);
        this.content = content;
        this.totalItems = totalItems;
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
    }

    @JsonProperty("data")
    public Collection<T> getContent() {
        return Collections.unmodifiableCollection(this.content);
    }

    @JsonProperty("totalItems")
    public Long getTotalItems() {
        return totalItems;
    }

    @JsonProperty("pageSize")
    public Integer getPageSize() {
        return pageSize;
    }

    @JsonProperty("pageNumber")
    public Integer getPageNumber() {
        return pageNumber;
    }
}
