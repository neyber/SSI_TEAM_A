package com.groupa.ssi.request.personalprotectionequipment;

import com.groupa.ssi.model.domain.catalog.PpeClassification;

/**
 * Created on April 25, 2018
 * @author Walker Colina
 */
public class PpeRequest {

    private String name;
    private String description;
    private PpeClassification ppeClassification;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PpeClassification getPpeClassification() {
        return ppeClassification;
    }

    public void setPpeClassification(PpeClassification ppeClassification) {
        this.ppeClassification = ppeClassification;
    }
}
