/*
@author: HENRYBC
*/
package com.groupa.ssi.response.accident;

import com.groupa.ssi.model.domain.accident.Accident;
import com.groupa.ssi.response.personnel.EmployeeResponse;
import com.groupa.ssi.response.personnel.EmployeeResponseBuilder;
import com.groupa.ssi.response.saClassification.SaCategoryResponse;
import com.groupa.ssi.response.saClassification.SaCategoryResponseBuilder;
import com.groupa.ssi.response.saClassification.SaTypeResponse;
import com.groupa.ssi.response.saClassification.SaTypeResponseBuilder;

import java.util.Date;

public class AccidentResponseBuilder {
    private Integer accidentId;
    private String description;
    private Date dateAccident;
    private String whereOccurr;
    private Boolean statusRecord;
    private Integer totalDaysOutOfWork;
    private Integer totalDaysRestrictedTransferredWork;
    private SaCategoryResponse saCategoryResponse;
    private SaTypeResponse saTypeResponse;
    private EmployeeResponse employee;

    private AccidentResponseBuilder(){}

    public AccidentResponse build(){
        AccidentResponse accidentResponse = new AccidentResponse();
        accidentResponse.setAccidentId(accidentId);
        accidentResponse.setDescription(description);
        accidentResponse.setDateAccident(dateAccident);
        accidentResponse.setWhereOccurr(whereOccurr);
        accidentResponse.setStatusRecord(statusRecord);
        accidentResponse.setTotalDaysOutOfWork(totalDaysOutOfWork);
        accidentResponse.setTotalDaysRestrictedTransferredWork(totalDaysRestrictedTransferredWork);
        accidentResponse.setSaCategoryResponse(saCategoryResponse);
        accidentResponse.setSaTypeResponse(saTypeResponse);
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
        accidentResponseBuilder.setTotalDaysOutOfWork(accident.getTotalDaysOutOfWork());
        accidentResponseBuilder.setTotalDaysRestrictedTransferredWork(accident.getTotalDaysRestrictedTransferredWork());
        if (null != accident.getSaCategory()) {
            accidentResponseBuilder.setSaCategoryResponse(SaCategoryResponseBuilder.getInstance(accident.getSaCategory()).build());
        }

        if (null != accident.getSaType()) {
            accidentResponseBuilder.setSaTypeResponse(SaTypeResponseBuilder.getIsntance(accident.getSaType()).build());
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

    public AccidentResponseBuilder setTotalDaysOutOfWork(Integer totalDaysOutOfWork) {
        this.totalDaysOutOfWork = totalDaysOutOfWork;
        return this;
    }

    public AccidentResponseBuilder setTotalDaysRestrictedTransferredWork(Integer totalDaysRestrictedTransferredWork) {
        this.totalDaysRestrictedTransferredWork = totalDaysRestrictedTransferredWork;
        return this;
    }

    public AccidentResponseBuilder setSaCategoryResponse(SaCategoryResponse saCategoryResponse) {
        this.saCategoryResponse = saCategoryResponse;
        return this;
    }

    public AccidentResponseBuilder setSaTypeResponse(SaTypeResponse saTypeResponse) {
        this.saTypeResponse = saTypeResponse;
        return this;
    }

    public AccidentResponseBuilder setEmployee(EmployeeResponse employee) {
        this.employee = employee;
        return this;
    }
}
