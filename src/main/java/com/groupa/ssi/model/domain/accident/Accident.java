/*
@author: HENRYBC
*/
package com.groupa.ssi.model.domain.accident;

import com.groupa.ssi.model.domain.ModelBase;
import com.groupa.ssi.model.domain.catalog.SaClassification;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Accident extends ModelBase {

    @Column
    private String description;

    @Column
    private Date dateAccident;

    @Column
    private String whereOccurr;

    @Column
    private Boolean statusRecord;

    @ManyToOne
    private SaClassification saClassification;

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
