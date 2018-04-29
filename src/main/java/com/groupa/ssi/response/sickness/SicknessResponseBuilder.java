/*
@author: HENRYBC
*/
package com.groupa.ssi.response.sickness;

import com.groupa.ssi.model.domain.catalog.SaClassification;
import com.groupa.ssi.model.domain.sickness.Sickness;
import org.hibernate.cache.internal.SimpleCacheKeysFactory;

import java.util.Date;

public class SicknessResponseBuilder {
    private String description;
    private Date dateSickness;
    private String whereOccurr;
    private Boolean statusRecord;
    private SaClassification saClassification;

    public SicknessResponseBuilder(){}

    public SicknessResponse build(){
        SicknessResponse sicknessResponse = new SicknessResponse();
        sicknessResponse.setDescription(description);
        sicknessResponse.setDateSickness(dateSickness);
        sicknessResponse.setWhereOccurr(whereOccurr);
        sicknessResponse.setStatusRecord(statusRecord);
        sicknessResponse.setSaClassification(saClassification);

        return sicknessResponse;
    }

    public static SicknessResponseBuilder getInstance(Sickness sickness){
        return new SicknessResponseBuilder()
                .setDescription(sickness.getDescription())
                .setDateSickness(sickness.getDateSickness())
                .setWhereOccurr(sickness.getWhereOccurr())
                .setStatusRecord(sickness.getStatusRecord())
                .setSaClassification(sickness.getSaClassification());
    }

    public SicknessResponseBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public SicknessResponseBuilder setDateSickness(Date dateSickness) {
        this.dateSickness = dateSickness;
        return this;
    }

    public SicknessResponseBuilder setWhereOccurr(String whereOccurr) {
        this.whereOccurr = whereOccurr;
        return this;
    }

    public SicknessResponseBuilder setStatusRecord(Boolean statusRecord){
        this.statusRecord = statusRecord;
        return this;
    }

    public SicknessResponseBuilder setSaClassification(SaClassification saClassification){
        this.saClassification = saClassification;
        return this;
    }
}
