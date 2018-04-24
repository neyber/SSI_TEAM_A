package com.groupa.ssi.response.catalog;

import com.groupa.ssi.model.domain.catalog.WorkItem;

/**
 * @author Miguel Rojas
 */
public final class WorkItemResponseBuilder {

    private String name;
    private String description;

    private WorkItemResponseBuilder() {
    }

    public WorkItemResponse build() {
        WorkItemResponse workItemResponse = new WorkItemResponse();
        workItemResponse.setName(name);
        workItemResponse.setDescription(description);

        return workItemResponse;
    }

    public static WorkItemResponseBuilder getInstance(WorkItem workItem) {
        return new WorkItemResponseBuilder()
                .setName(workItem.getName())
                .setDescription(workItem.getDescription());
    }

    public WorkItemResponseBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public WorkItemResponseBuilder setDescription(String description) {
        this.description = description;
        return this;
    }
}
