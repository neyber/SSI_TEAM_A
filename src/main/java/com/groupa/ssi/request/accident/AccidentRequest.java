/*
@author: HENRYBC
*/
package com.groupa.ssi.request.accident;

import java.util.Date;

public class AccidentRequest {

    private String description;
    private Date dateAccident;
    private String whereOccurr;
    private Boolean statusRecord;
    private Integer totalDaysOutOfWork;
    private Integer totalDaysRestrictedTransferredWork;
    private Integer saCategoryId;
    private Integer saTypeId;
    private Integer employeeId;

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

    public Integer getSaCategoryId() {
        return saCategoryId;
    }

    public void setSaCategoryId(Integer saCategoryId) {
        this.saCategoryId = saCategoryId;
    }

    public Integer getSaTypeId() {
        return saTypeId;
    }

    public void setSaTypeId(Integer saTypeId) {
        this.saTypeId = saTypeId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }
}
