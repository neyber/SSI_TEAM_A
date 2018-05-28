package com.groupa.ssi.model.domain.workitem;

import com.groupa.ssi.model.domain.ModelBase;
import com.groupa.ssi.model.domain.catalog.WorkItemClassification;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Miguel Rojas
 * @Modified : Linet Torrico
 */
@Entity
public class WorkItem  extends ModelBase {

    @Column
    private String name;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name = "workItemClassificationId")
    private WorkItemClassification workItemClassification;

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

    public WorkItemClassification getWorkItemClassification() {
        return workItemClassification;
    }

    public void setWorkItemClassification(WorkItemClassification workItemClassification) {
        this.workItemClassification = workItemClassification;
    }
}
