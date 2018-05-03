/*
@author: HENRYBC
*/
package com.groupa.ssi.request.accident;

import com.groupa.ssi.model.domain.catalog.SaClassification;
import com.groupa.ssi.request.catalog.SaClassificationRequest;

import java.util.Date;

public class AccidentRequest {

    private String description;
    private Date dateAccident;
    private String whereOccurr;
    private Boolean statusRecord;
    private Integer saClassificationId;

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

    public Integer getSaClassificationId() {
        return saClassificationId;
    }

    public void setSaClassificationId(Integer saClassificationId) {
        this.saClassificationId = saClassificationId;
    }
}
