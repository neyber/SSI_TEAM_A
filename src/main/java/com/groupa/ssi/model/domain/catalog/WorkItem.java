package com.groupa.ssi.model.domain.catalog;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Miguel Rojas
 */
@Entity
public class WorkItem {

    @Id
    @Column
    private Integer workItemId;

    @Column
    private String name;

    @Column
    private String description;

    public Integer getWorkItemId() {
        return workItemId;
    }

    public void setWorkItemId(Integer workItemId) {
        this.workItemId = workItemId;
    }

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
