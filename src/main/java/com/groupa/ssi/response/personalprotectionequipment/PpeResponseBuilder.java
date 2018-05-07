package com.groupa.ssi.response.personalprotectionequipment;

import com.groupa.ssi.model.domain.personalprotectionequipment.Ppe;
import com.groupa.ssi.response.catalog.PpeClassificationResponse;
import com.groupa.ssi.response.catalog.PpeClassificationResponseBuilder;

/**
 * Created on April 25, 2018
 * @author Walker Colina
 */
public final class PpeResponseBuilder {

    private Integer ppeId;
    private String name;
    private String description;
    //private Byte[] image;
    private PpeClassificationResponse ppeClassification;

    private PpeResponseBuilder() {
    }

    public PpeResponse build() {
        PpeResponse ppeResponse = new PpeResponse();
        ppeResponse.setPpeId(ppeId);
        ppeResponse.setName(name);
        ppeResponse.setDescription(description);
        //ppeResponse.setImage(image);
        ppeResponse.setPpeClassification(ppeClassification);

        return ppeResponse;
    }


    public static PpeResponseBuilder getInstance(Ppe ppe) {
        PpeResponseBuilder ppeResponseBuilder = new PpeResponseBuilder();
        ppeResponseBuilder.setPpeId(ppe.getId());
        ppeResponseBuilder.setName(ppe.getName());
        ppeResponseBuilder.setDescription(ppe.getDescription());
        //ppeResponseBuilder.setImage(ppe.getImage());
        if(ppe.getPpeClassification() != null) {
            ppeResponseBuilder.setPpeClassification(PpeClassificationResponseBuilder.getInstance(ppe.getPpeClassification()).build());
        }

        return ppeResponseBuilder;
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

    /*public PpeResponseBuilder setImage(Byte[] image) {
        this.image = image;
        return this;
    }*/

    public PpeResponseBuilder setPpeClassification(PpeClassificationResponse ppeClassification) {
        this.ppeClassification = ppeClassification;
        return this;
    }
}
