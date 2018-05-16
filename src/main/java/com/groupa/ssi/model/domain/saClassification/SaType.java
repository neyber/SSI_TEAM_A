package com.groupa.ssi.model.domain.saClassification;

import com.groupa.ssi.model.domain.ModelBase;

import javax.persistence.Column;
import javax.persistence.Entity;

/*
Created on 13/5/18
@author: HENRYBC
*/
@Entity
public class SaType extends ModelBase {

    @Column
    private String type;

    @Column
    private String Description;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
