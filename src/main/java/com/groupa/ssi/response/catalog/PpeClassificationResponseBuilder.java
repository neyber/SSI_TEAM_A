package com.groupa.ssi.response.catalog;

import com.groupa.ssi.model.domain.catalog.PpeClassification;

/**
 * Created on April 25, 2018
 * @author Walker Colina
 */
public final class PpeClassificationResponseBuilder {

    private int id;
    private String name;
    private String description;

    private PpeClassificationResponseBuilder() {
    }

    public PpeClassificationResponse build() {
        PpeClassificationResponse ppeClassificationResponse = new PpeClassificationResponse();
        ppeClassificationResponse.setPpeClassificationId(id);
        ppeClassificationResponse.setName(name);
        ppeClassificationResponse.setDescription(description);

        return ppeClassificationResponse;
    }


    public static PpeClassificationResponseBuilder getInstance(PpeClassification ppeClassification) {
        return new PpeClassificationResponseBuilder()
                .setId(ppeClassification.getId())
                .setName(ppeClassification.getName())
                .setDescription(ppeClassification.getDescription());
    }

    public PpeClassificationResponseBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public PpeClassificationResponseBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PpeClassificationResponseBuilder setDescription(String description) {
        this.description = description;
        return this;
    }
}
