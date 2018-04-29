/*
@author: HENRYBC
*/
package com.groupa.ssi.response.accident;

import com.groupa.ssi.model.domain.accident.Accident;
import com.groupa.ssi.model.domain.catalog.SaClassification;

import java.util.Date;

public class AccidentResponseBuilder {
    private String description;
    private Date dateAccident;
    private String whereOccurr;
    private Boolean statusRecord;
    private SaClassification saClassification;

    private AccidentResponseBuilder(){}

    public AccidentResponse build(){
        AccidentResponse accidentResponse = new AccidentResponse();
        accidentResponse.setDescription(description);
        accidentResponse.setDateAccident(dateAccident);
        accidentResponse.setWhereOccurr(whereOccurr);
        accidentResponse.setStatusRecord(statusRecord);
        accidentResponse.setSaClassification(saClassification);

        return accidentResponse;
    }

    public static AccidentResponseBuilder getInstance(Accident accident){
        return new AccidentResponseBuilder()
                .setDescription(accident.getDescription())
                .setDateAccident(accident.getDateAccident())
                .setWhereOccurr(accident.getWhereOccurr())
                .setStatusRecord(accident.getStatusRecord())
                .setSaClassification(accident.getSaClassification());
    }

    public AccidentResponseBuilder setDescription(String description){
        this.description = description;
        return this;
    }

    public AccidentResponseBuilder setDateAccident(Date dateAccident){
        this.dateAccident = dateAccident;
        return this;
    }

    public AccidentResponseBuilder setWhereOccurr(String whereOccurr){
        this.whereOccurr = whereOccurr;
        return this;
    }

    public AccidentResponseBuilder setStatusRecord(Boolean statusRecord){
        this.statusRecord = statusRecord;
        return this;
    }

    public AccidentResponseBuilder setSaClassification(SaClassification saClassification){
        this.saClassification = saClassification;
        return this;
    }
}
