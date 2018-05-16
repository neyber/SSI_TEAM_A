/*
@author: HENRYBC
*/
package com.groupa.ssi.response.sickness;

import com.groupa.ssi.model.domain.sickness.Sickness;
import com.groupa.ssi.response.accident.AccidentResponseBuilder;
import com.groupa.ssi.response.catalog.SaClassificationResponse;
import com.groupa.ssi.response.catalog.SaClassificationResponseBuilder;
import com.groupa.ssi.response.personnel.EmployeeResponse;
import com.groupa.ssi.response.personnel.EmployeeResponseBuilder;
import com.groupa.ssi.response.saClassification.SaCategoryResponse;
import com.groupa.ssi.response.saClassification.SaCategoryResponseBuilder;
import com.groupa.ssi.response.saClassification.SaTypeResponse;
import com.groupa.ssi.response.saClassification.SaTypeResponseBuilder;

import java.util.Date;

public class SicknessResponseBuilder {
    private Integer sicknessId;
    private String description;
    private Date dateSickness;
    private String whereOccurr;
    private Boolean statusRecord;
    private Integer totalDaysOutOfWork;
    private Integer totalDaysRestrictedTransferredWork;
    private SaCategoryResponse saCategoryResponse;
    private SaTypeResponse saTypeResponse;
    private EmployeeResponse employee;

    public SicknessResponseBuilder(){}

    public SicknessResponse build(){
        SicknessResponse sicknessResponse = new SicknessResponse();
        sicknessResponse.setSicknessId(sicknessId);
        sicknessResponse.setDescription(description);
        sicknessResponse.setDateSickness(dateSickness);
        sicknessResponse.setWhereOccurr(whereOccurr);
        sicknessResponse.setStatusRecord(statusRecord);
        sicknessResponse.setTotalDaysOutOfWork(totalDaysOutOfWork);
        sicknessResponse.setTotalDaysRestrictedTransferredWork(totalDaysRestrictedTransferredWork);
        sicknessResponse.setSaCategoryResponse(saCategoryResponse);
        sicknessResponse.setSaTypeResponse(saTypeResponse);
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
        sicknessResponseBuilder.setTotalDaysOutOfWork(sickness.getTotalDaysOutOfWork());
        sicknessResponseBuilder.setTotalDaysRestrictedTransferredWork(sickness.getTotalDaysRestrictedTransferredWork());
        if (null != sickness.getSaCategory()) {
            sicknessResponseBuilder.setSaCategoryResponse(SaCategoryResponseBuilder.getInstance(sickness.getSaCategory()).build());
        }

        if (null != sickness.getSaType()) {
            sicknessResponseBuilder.setSaTypeResponse(SaTypeResponseBuilder.getIsntance(sickness.getSaType()).build());
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

    public SicknessResponseBuilder setTotalDaysOutOfWork(Integer totalDaysOutOfWork) {
        this.totalDaysOutOfWork = totalDaysOutOfWork;
        return this;
    }

    public SicknessResponseBuilder setTotalDaysRestrictedTransferredWork(Integer totalDaysRestrictedTransferredWork) {
        this.totalDaysRestrictedTransferredWork = totalDaysRestrictedTransferredWork;
        return this;
    }

    public SicknessResponseBuilder setSaCategoryResponse(SaCategoryResponse saCategoryResponse) {
        this.saCategoryResponse = saCategoryResponse;
        return this;
    }

    public SicknessResponseBuilder setSaTypeResponse(SaTypeResponse saTypeResponse) {
        this.saTypeResponse = saTypeResponse;
        return this;
    }

    public SicknessResponseBuilder setEmployee(EmployeeResponse employee) {
        this.employee = employee;
        return this;
    }
}
