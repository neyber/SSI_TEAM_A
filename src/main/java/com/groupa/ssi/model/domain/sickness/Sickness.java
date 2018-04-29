/*
@author: HENRYBC
*/
package com.groupa.ssi.model.domain.sickness;

import com.groupa.ssi.model.domain.ModelBase;
import com.groupa.ssi.model.domain.catalog.SaClassification;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Sickness extends ModelBase {

    @Column
    private String description;

    @Column
    private Date dateSickness;

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

    public SaClassification getSaClassification() {
        return saClassification;
    }

    public void setSaClassification(SaClassification saClassification) {
        this.saClassification = saClassification;
    }
}
