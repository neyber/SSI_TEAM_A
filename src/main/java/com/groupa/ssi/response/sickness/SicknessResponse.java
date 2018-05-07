/*
@author: HENRYBC
*/
package com.groupa.ssi.response.sickness;

import com.groupa.ssi.model.domain.catalog.SaClassification;
import com.groupa.ssi.response.catalog.SaClassificationResponse;
import com.groupa.ssi.response.personnel.EmployeeResponse;

import java.util.Date;

public class SicknessResponse {
    private Integer sicknessId;
    private String description;
    private Date dateSickness;
    private String whereOccurr;
    private Boolean statusRecord;
    private SaClassificationResponse saClassification;
    private EmployeeResponse employee;

    public Integer getSicknessId() {
        return sicknessId;
    }

    public void setSicknessId(Integer sicknessId) {
        this.sicknessId = sicknessId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateSickness() {
        return dateSickness;
    }

    public void setDateSickness(Date dateSickness) {
        this.dateSickness = dateSickness;
    }

    public String getWhereOccurr() {
        return whereOccurr;
    }

    public void setWhereOccurr(String whereOccurr) {
        this.whereOccurr = whereOccurr;
    }

    public Boolean getStatusRecord() {
        return statusRecord;
    }

    public void setStatusRecord(Boolean statusRecord) {
        this.statusRecord = statusRecord;
    }

    public SaClassificationResponse getSaClassification() {
        return saClassification;
    }

    public void setSaClassification(SaClassificationResponse saClassification) {
        this.saClassification = saClassification;
    }

    public EmployeeResponse getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeResponse employee) {
        this.employee = employee;
    }
}
