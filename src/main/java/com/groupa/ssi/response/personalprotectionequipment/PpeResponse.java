package com.groupa.ssi.response.personalprotectionequipment;

import com.groupa.ssi.model.domain.catalog.PpeClassification;
import com.groupa.ssi.response.catalog.PpeClassificationResponse;

/**
 * Created on April 25, 2018
 * @author Walker Colina
 */
public class PpeResponse {

    private Integer ppeResponseId;
    private String name;
    private String description;
    private Byte[] image;
    private PpeClassification ppeClassification;

    public Integer getPpeResponseId() {
        return ppeResponseId;
    }

    public void setPpeResponseId(Integer ppeResponseId) {
        this.ppeResponseId = ppeResponseId;
    }

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

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    public PpeClassification getPpeClassification() {
        return ppeClassification;
    }

    public void setPpeClassification(PpeClassification ppeClassification) {
        this.ppeClassification = ppeClassification;
    }
}
