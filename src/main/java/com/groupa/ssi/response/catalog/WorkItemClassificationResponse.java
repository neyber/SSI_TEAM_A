package com.groupa.ssi.response.catalog;

/**
 * Created on May 1, 2018
 * @author Walker Colina
 */
public class WorkItemClassificationResponse {

    private Integer workItemClassificationId;
    private String name;
    private String description;

    public int getWorkItemClassificationId() {
        return workItemClassificationId;
    }

    public void setWorkItemClassificationId(Integer workItemClassificationId) {
        this.workItemClassificationId = workItemClassificationId;
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
