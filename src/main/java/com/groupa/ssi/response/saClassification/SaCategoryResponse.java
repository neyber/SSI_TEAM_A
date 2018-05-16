package com.groupa.ssi.response.saClassification;

/*
Created on 13/5/18
@author: HENRYBC
*/
public class SaCategoryResponse {

    private Integer saCategoryId;
    private String category;
    private String description;
    private String reference;

    public Integer getSaCategoryId() {
        return saCategoryId;
    }

    public void setSaCategoryId(Integer saCategoryId) {
        this.saCategoryId = saCategoryId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}
