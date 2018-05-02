package com.groupa.ssi.response.workitem;

import com.groupa.ssi.model.domain.workitem.WorkItem;
import com.groupa.ssi.response.catalog.WorkItemClassificationResponse;
import com.groupa.ssi.response.catalog.WorkItemClassificationResponseBuilder;

/**
 * @author Miguel Rojas
 */
public final class WorkItemResponseBuilder {

    private Integer workItemId;
    private String name;
    private String description;
    private WorkItemClassificationResponse workItemClassification;

    private WorkItemResponseBuilder() {
    }

    public WorkItemResponse build() {
        WorkItemResponse workItemResponse = new WorkItemResponse();
        workItemResponse.setWorkItemId(workItemId);
        workItemResponse.setName(name);
        workItemResponse.setDescription(description);
        workItemResponse.setWorkItemClassification(workItemClassification);

        return workItemResponse;
    }

    public static WorkItemResponseBuilder getInstance(WorkItem workItem) {
        WorkItemResponseBuilder workItemResponseBuilder = new WorkItemResponseBuilder();
        workItemResponseBuilder.setWorkItemId(workItem.getId());
        workItemResponseBuilder.setName(workItem.getName());
        workItemResponseBuilder.setDescription(workItem.getDescription());
        if(workItem.getWorkItemClassification() != null) {
            workItemResponseBuilder.setWorkItemClassification(WorkItemClassificationResponseBuilder.getInstance(workItem.getWorkItemClassification()).build());
        }
        return workItemResponseBuilder;
    }

    public WorkItemResponseBuilder setWorkItemId(Integer workItemId) {
        this.workItemId = workItemId;
        return this;
    }

    public WorkItemResponseBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public WorkItemResponseBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public WorkItemResponseBuilder setWorkItemClassification(WorkItemClassificationResponse workItemClassification){
        this.workItemClassification = workItemClassification;
        return this;
    }
}
