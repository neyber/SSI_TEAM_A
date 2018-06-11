package com.groupa.ssi.model.domain.catalog;

import com.groupa.ssi.model.domain.ModelBase;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * This class is top represent the catalog for classification of work item
 * Created on May 1, 2018
 *
 * @author Walker Colina
 */
@Entity
public class WorkItemClassification extends ModelBase {

    @Column
    private String name;

    @Column
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
