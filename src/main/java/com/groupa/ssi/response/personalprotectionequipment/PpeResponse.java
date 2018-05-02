package com.groupa.ssi.response.personalprotectionequipment;

import com.groupa.ssi.response.catalog.PpeClassificationResponse;

/**
 * Created on April 25, 2018
 * @author Walker Colina
 */
public class PpeResponse {

    private Integer ppeId;
    private String name;
    private String description;
    //private Byte[] image;
    private PpeClassificationResponse ppeClassification;

    public Integer getPpeId() {
        return ppeId;
    }

    public void setPpeId(Integer ppeId) {
        this.ppeId = ppeId;
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

    /*public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }*/

    public PpeClassificationResponse getPpeClassification() {
        return ppeClassification;
    }

    public void setPpeClassification(PpeClassificationResponse ppeClassification) {
        this.ppeClassification = ppeClassification;
    }
}
