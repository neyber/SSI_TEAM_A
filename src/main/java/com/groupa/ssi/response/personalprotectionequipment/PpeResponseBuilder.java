package com.groupa.ssi.response.personalprotectionequipment;

import com.groupa.ssi.model.domain.catalog.PpeClassification;
import com.groupa.ssi.model.domain.personalprotectionequipment.Ppe;

/**
 * Created on April 25, 2018
 * @author Walker Colina
 */
public class PpeResponseBuilder {

    private String name;
    private String description;
    private PpeClassification ppeClassification;

    private PpeResponseBuilder() {
    }

    public PpeResponse build() {
        PpeResponse ppeResponse = new PpeResponse();
        ppeResponse.setName(name);
        ppeResponse.setDescription(description);
        ppeResponse.setPpeClassification(ppeClassification);

        return ppeResponse;
    }


    public static PpeResponseBuilder getInstance(Ppe ppe) {
        return new PpeResponseBuilder()
                .setName(ppe.getName())
                .setDescription(ppe.getDescription())
                .setPpeClassification(ppe.getPpeClassification());
    }

    public PpeResponseBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PpeResponseBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public PpeResponseBuilder setPpeClassification(PpeClassification ppeClassification) {
        this.ppeClassification = ppeClassification;
        return this;
    }
}
