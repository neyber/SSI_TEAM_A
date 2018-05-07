package com.groupa.ssi.response.workitem;

import com.groupa.ssi.response.catalog.WorkItemClassificationResponse;

/**
 * @author Miguel Rojas
 */
public class WorkItemResponse {

    private Integer workItemId;
    private String name;
    private String description;
    private WorkItemClassificationResponse workItemClassification;

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

    public WorkItemClassificationResponse getWorkItemClassification() {
        return workItemClassification;
    }

    public void setWorkItemClassification(WorkItemClassificationResponse workItemClassification) {
        this.workItemClassification = workItemClassification;
    }
}
