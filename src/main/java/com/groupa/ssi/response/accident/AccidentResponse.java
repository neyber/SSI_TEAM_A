/*
@author: HENRYBC
*/
package com.groupa.ssi.response.accident;

import com.groupa.ssi.model.domain.catalog.SaClassification;
import com.groupa.ssi.response.catalog.SaClassificationResponse;

import java.util.Date;

public class AccidentResponse {

    private Integer accidentId;
    private String description;
    private Date dateAccident;
    private String whereOccurr;
    private Boolean statusRecord;
    private SaClassification saClassification;

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

    public SaClassification getSaClassification() {
        return saClassification;
    }

    public void setSaClassification(SaClassification saClassification) {
        this.saClassification = saClassification;
    }
}
