/*
@author: HENRYBC
*/
package com.groupa.ssi.response.accident;

import com.groupa.ssi.model.domain.accident.Accident;
import com.groupa.ssi.model.domain.catalog.SaClassification;
import com.groupa.ssi.response.catalog.SaClassificationResponse;
import com.groupa.ssi.response.catalog.SaClassificationResponseBuilder;
import com.groupa.ssi.response.personnel.EmployeeResponse;
import com.groupa.ssi.response.personnel.EmployeeResponseBuilder;

import java.util.Date;

public class AccidentResponseBuilder {
    private Integer accidentId;
    private String description;
    private Date dateAccident;
    private String whereOccurr;
    private Boolean statusRecord;
    private SaClassificationResponse saClassification;
    private EmployeeResponse employee;

    private AccidentResponseBuilder(){}

    public AccidentResponse build(){
        AccidentResponse accidentResponse = new AccidentResponse();
        accidentResponse.setAccidentId(accidentId);
        accidentResponse.setDescription(description);
        accidentResponse.setDateAccident(dateAccident);
        accidentResponse.setWhereOccurr(whereOccurr);
        accidentResponse.setStatusRecord(statusRecord);
        accidentResponse.setSaClassification(saClassification);
        accidentResponse.setEmployee(employee);

        return accidentResponse;
    }

    public static AccidentResponseBuilder getInstance(Accident accident){
        AccidentResponseBuilder accidentResponseBuilder = new AccidentResponseBuilder();
        accidentResponseBuilder.setAccidentId(accident.getId());
        accidentResponseBuilder.setDescription(accident.getDescription());
        accidentResponseBuilder.setDateAccident(accident.getDateAccident());
        accidentResponseBuilder.setWhereOccurr(accident.getWhereOccurr());
        accidentResponseBuilder.setStatusRecord(accident.getStatusRecord());
        if (null != accident.getSaClassification()) {
            accidentResponseBuilder.setSaClassification(SaClassificationResponseBuilder.getInstance(accident.getSaClassification()).build());
        }

        if (null != accident.getEmployee()) {
            accidentResponseBuilder.setEmployee(EmployeeResponseBuilder.getInstance(accident.getEmployee()).build());
        }

        return accidentResponseBuilder;

    }

    public AccidentResponseBuilder setAccidentId(Integer accidentId) {
        this.accidentId = accidentId;
        return this;
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

    public AccidentResponseBuilder setSaClassification(SaClassificationResponse saClassification){
        this.saClassification = saClassification;
        return this;
    }

    public AccidentResponseBuilder setEmployee(EmployeeResponse employee) {
        this.employee = employee;
        return this;
    }
}
