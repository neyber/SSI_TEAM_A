package com.groupa.ssi.response.personalprotectionequipment;

import com.groupa.ssi.model.domain.catalog.PpeClassification;
import com.groupa.ssi.model.domain.personalprotectionequipment.Ppe;
import com.groupa.ssi.response.catalog.PpeClassificationResponse;

/**
 * Created on April 25, 2018
 * @author Walker Colina
 */
public final class PpeResponseBuilder {

    private Integer ppeId;
    private String name;
    private String description;
    private Byte[] image;
    private PpeClassification ppeClassification;

    private PpeResponseBuilder() {
    }

    public PpeResponse build() {
        PpeResponse ppeResponse = new PpeResponse();
        ppeResponse.setPpeResponseId(ppeId);
        ppeResponse.setName(name);
        ppeResponse.setDescription(description);
        ppeResponse.setImage(image);
        ppeResponse.setPpeClassification(ppeClassification);

        return ppeResponse;
    }


    public static PpeResponseBuilder getInstance(Ppe ppe) {
        return new PpeResponseBuilder()
                .setPpeId(ppe.getId())
                .setName(ppe.getName())
                .setDescription(ppe.getDescription())
                .setImage(ppe.getImage())
                .setPpeClassification(ppe.getPpeClassification());
    }

    public PpeResponseBuilder setPpeId(Integer ppeId) {
        this.ppeId = ppeId;
        return this;
    }

    public PpeResponseBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PpeResponseBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public PpeResponseBuilder setImage(Byte[] image) {
        this.image = image;
        return this;
    }

    public PpeResponseBuilder setPpeClassification(PpeClassification ppeClassification) {
        this.ppeClassification = ppeClassification;
        return this;
    }
}
