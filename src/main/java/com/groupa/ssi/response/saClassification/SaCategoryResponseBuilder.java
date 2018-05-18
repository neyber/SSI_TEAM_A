package com.groupa.ssi.response.saClassification;

import com.groupa.ssi.model.domain.saClassification.SaCategory;

/*
Created on 13/5/18
@author: HENRYBC
*/
public class SaCategoryResponseBuilder {

    private Integer saCategoryId;
    private String category;
    private String description;
    private String reference;

    private SaCategoryResponseBuilder() {}

    public SaCategoryResponse build() {
        SaCategoryResponse saCategoryResponse = new SaCategoryResponse();
        saCategoryResponse.setSaCategoryId(saCategoryId);
        saCategoryResponse.setCategory(category);
        saCategoryResponse.setDescription(description);
        saCategoryResponse.setReference(reference);

        return saCategoryResponse;
    }

    public static SaCategoryResponseBuilder getInstance(SaCategory saCategory) {
        SaCategoryResponseBuilder saCategoryResponseBuilder = new SaCategoryResponseBuilder();
        saCategoryResponseBuilder.setSaCategoryId(saCategory.getId());
        saCategoryResponseBuilder.setCategory(saCategory.getCategory());
        saCategoryResponseBuilder.setDescription(saCategory.getDescription());
        saCategoryResponseBuilder.setReference(saCategory.getReference());
        return saCategoryResponseBuilder;
    }

    public SaCategoryResponseBuilder setSaCategoryId(Integer saCategoryId) {
        this.saCategoryId = saCategoryId;
        return this;
    }

    public SaCategoryResponseBuilder setCategory(String category) {
        this.category = category;
        return this;
    }

    public SaCategoryResponseBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public SaCategoryResponseBuilder setReference(String reference) {
        this.reference = reference;
        return this;
    }
}
