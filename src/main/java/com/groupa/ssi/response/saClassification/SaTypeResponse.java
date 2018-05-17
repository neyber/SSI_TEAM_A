package com.groupa.ssi.response.saClassification;

/*
Created on 13/5/18
@author: HENRYBC
*/
public class SaTypeResponse {

    private Integer saTypeId;
    private String type;
    private String description;

    public Integer getSaTypeId() {
        return saTypeId;
    }

    public void setSaTypeId(Integer saTypeId) {
        this.saTypeId = saTypeId;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
