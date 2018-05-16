package com.groupa.ssi.response.saClassification;

import com.groupa.ssi.model.domain.saClassification.SaType;

import javax.security.sasl.SaslServer;

/*
Created on 13/5/18
@author: HENRYBC
*/
public class SaTypeResponseBuilder {

    private Integer saTypeId;
    private String type;
    private String description;

    private SaTypeResponseBuilder() {}

    public SaTypeResponse build() {
        SaTypeResponse saTypeResponse = new SaTypeResponse();
        saTypeResponse.setSaTypeId(saTypeId);
        saTypeResponse.setType(type);
        saTypeResponse.setDescription(description);

        return saTypeResponse;
    }

    public static SaTypeResponseBuilder getIsntance(SaType saType) {
        SaTypeResponseBuilder saTypeResponseBuilder = new SaTypeResponseBuilder();
        saTypeResponseBuilder.setSaTypeId(saType.getId());
        saTypeResponseBuilder.setType(saType.getType());
        saTypeResponseBuilder.setDescription(saType.getDescription());

        return saTypeResponseBuilder;
    }

    public SaTypeResponseBuilder setSaTypeId(Integer saTypeId) {
        this.saTypeId = saTypeId;
        return this;
    }

    public SaTypeResponseBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public SaTypeResponseBuilder setDescription(String description) {
        this.description = description;
        return this;
    }
}
