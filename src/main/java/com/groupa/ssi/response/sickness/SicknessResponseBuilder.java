/*
@author: HENRYBC
*/
package com.groupa.ssi.response.sickness;

import com.groupa.ssi.model.domain.catalog.SaClassification;
import com.groupa.ssi.model.domain.personnel.Employee;
import com.groupa.ssi.model.domain.sickness.Sickness;
import com.groupa.ssi.response.catalog.SaClassificationResponse;
import com.groupa.ssi.response.catalog.SaClassificationResponseBuilder;
import com.groupa.ssi.response.personnel.EmployeeResponse;
import com.groupa.ssi.response.personnel.EmployeeResponseBuilder;
import org.hibernate.cache.internal.SimpleCacheKeysFactory;

import java.util.Date;

public class SicknessResponseBuilder {
    private Integer sicknessId;
    private String description;
    private Date dateSickness;
    private String whereOccurr;
    private Boolean statusRecord;
    private SaClassificationResponse saClassification;
    private EmployeeResponse employee;

    public SicknessResponseBuilder(){}

    public SicknessResponse build(){
        SicknessResponse sicknessResponse = new SicknessResponse();
        sicknessResponse.setSicknessId(sicknessId);
        sicknessResponse.setDescription(description);
        sicknessResponse.setDateSickness(dateSickness);
        sicknessResponse.setWhereOccurr(whereOccurr);
        sicknessResponse.setStatusRecord(statusRecord);
        sicknessResponse.setSaClassification(saClassification);
        sicknessResponse.setEmployee(employee);

        return sicknessResponse;
    }

    public static SicknessResponseBuilder getInstance(Sickness sickness){
        SicknessResponseBuilder sicknessResponseBuilder = new SicknessResponseBuilder();

        sicknessResponseBuilder.setSicknessId(sickness.getId());
        sicknessResponseBuilder.setDescription(sickness.getDescription());
        sicknessResponseBuilder.setDateSickness(sickness.getDateSickness());
        sicknessResponseBuilder.setWhereOccurr(sickness.getWhereOccurr());
        sicknessResponseBuilder.setStatusRecord(sickness.getStatusRecord());
        if (null != sickness.getSaClassification()) {
            sicknessResponseBuilder.setSaClassification(SaClassificationResponseBuilder.getInstance(sickness.getSaClassification()).build());
        }

        if(null != sickness.getEmployee()) {
            sicknessResponseBuilder.setEmployee(EmployeeResponseBuilder.getInstance(sickness.getEmployee()).build());
        }

        return sicknessResponseBuilder;

    }


    public SicknessResponseBuilder setSicknessId(Integer sicknessId) {
        this.sicknessId = sicknessId;
        return this;
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

    public SicknessResponseBuilder setSaClassification(SaClassificationResponse saClassification){
        this.saClassification = saClassification;
        return this;
    }

    public SicknessResponseBuilder setEmployee(EmployeeResponse employee) {
        this.employee = employee;
        return this;
    }
}
