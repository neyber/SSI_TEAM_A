package com.groupa.ssi.request.workitem;

/**
 * @author Miguel Rojas
 */
public class WorkItemRequest {

    private String name;
    private String description;
    private Integer workItemClassificationId;

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

    public Integer getWorkItemClassificationId() {
        return workItemClassificationId;
    }

    public void setWorkItemClassificationId(Integer workItemClassificationId) {
        this.workItemClassificationId = workItemClassificationId;
    }
}
