/*
@author: HENRYBC
*/
package com.groupa.ssi.request.sickness;

import com.groupa.ssi.model.domain.catalog.SaClassification;

import java.util.Date;

public class SicknessRequest {
    private String description;
    private Date dateSickness;
    private String whereOccurr;
    private Boolean statusRecord;
    private Integer saClassificationId;

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

    public Integer getSaClassificationId() {
        return saClassificationId;
    }

    public void setSaClassificationId(Integer saClassificationId) {
        this.saClassificationId = saClassificationId;
    }
}
