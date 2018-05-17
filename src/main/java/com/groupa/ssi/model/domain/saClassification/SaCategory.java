package com.groupa.ssi.model.domain.saClassification;

import com.groupa.ssi.model.domain.ModelBase;

import javax.persistence.Column;
import javax.persistence.Entity;

/*
Created on 13/5/18
@author: HENRYBC
*/
@Entity
public class SaCategory extends ModelBase {

    @Column
    private String category;

    @Column
    private String description;

    @Column
    private String reference;


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}
