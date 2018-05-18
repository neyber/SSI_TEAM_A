/*
@author: HENRYBC
*/
package com.groupa.ssi.response.accident;

import com.groupa.ssi.response.personnel.EmployeeResponse;
import com.groupa.ssi.response.saClassification.SaCategoryResponse;
import com.groupa.ssi.response.saClassification.SaTypeResponse;

import java.util.Date;

public class AccidentResponse {

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

    public Integer getAccidentId() {
        return accidentId;
    }

    public void setAccidentId(Integer accidentId) {
        this.accidentId = accidentId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateAccident() {
        return dateAccident;
    }

    public void setDateAccident(Date dateAccident) {
        this.dateAccident = dateAccident;
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

    public Integer getTotalDaysOutOfWork() {
        return totalDaysOutOfWork;
    }

    public void setTotalDaysOutOfWork(Integer totalDaysOutOfWork) {
        this.totalDaysOutOfWork = totalDaysOutOfWork;
    }

    public Integer getTotalDaysRestrictedTransferredWork() {
        return totalDaysRestrictedTransferredWork;
    }

    public void setTotalDaysRestrictedTransferredWork(Integer totalDaysRestrictedTransferredWork) {
        this.totalDaysRestrictedTransferredWork = totalDaysRestrictedTransferredWork;
    }

    public SaCategoryResponse getSaCategoryResponse() {
        return saCategoryResponse;
    }

    public void setSaCategoryResponse(SaCategoryResponse saCategoryResponse) {
        this.saCategoryResponse = saCategoryResponse;
    }

    public SaTypeResponse getSaTypeResponse() {
        return saTypeResponse;
    }

    public void setSaTypeResponse(SaTypeResponse saTypeResponse) {
        this.saTypeResponse = saTypeResponse;
    }

    public EmployeeResponse getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeResponse employee) {
        this.employee = employee;
    }
}
