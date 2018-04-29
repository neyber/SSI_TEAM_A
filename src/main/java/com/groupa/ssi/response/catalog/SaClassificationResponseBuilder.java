package com.groupa.ssi.response.catalog;
/*
Created on 28/4/18
@author: HENRYBC
*/

import com.groupa.ssi.model.domain.catalog.SaClassification;

public class SaClassificationResponseBuilder {

    private String category;

    private Integer totalDaysOutOfWork;

    private Integer totalDaysRestrictedTransferredWork;

    private String type;


    public SaClassificationResponse build() {
        SaClassificationResponse saClassificationResponse = new SaClassificationResponse();
        saClassificationResponse.setCategory(category);
        saClassificationResponse.setTotalDaysOutOfWork(totalDaysOutOfWork);
        saClassificationResponse.setTotalDaysRestrictedTransferredWork(totalDaysRestrictedTransferredWork);
        saClassificationResponse.setType(type);

        return saClassificationResponse;
    }

    public static SaClassificationResponseBuilder getInstance(SaClassification saClassification){
        return new SaClassificationResponseBuilder()
                .setCategory(saClassification.getCategory())
                .setTotalDaysOutOfWork(saClassification.getTotalDaysOutOfWork())
                .setTotalDaysRestrictedTransferredWork(saClassification.getTotalDaysRestrictedTransferredWork())
                .setType(saClassification.getType());
    }

    public SaClassificationResponseBuilder setCategory(String category){
        this.category = category;
        return this;
    }

    public SaClassificationResponseBuilder setTotalDaysOutOfWork(Integer totalDaysOutOfWork){
        this.totalDaysOutOfWork = totalDaysOutOfWork;
        return this;
    }

    public SaClassificationResponseBuilder setTotalDaysRestrictedTransferredWork(Integer totalDaysRestrictedTransferredWork){
        this.totalDaysRestrictedTransferredWork = totalDaysRestrictedTransferredWork;
        return this;
    }

    public SaClassificationResponseBuilder setType(String type){
        this.type = type;
        return this;
    }
}
