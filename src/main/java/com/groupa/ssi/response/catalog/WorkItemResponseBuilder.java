package com.groupa.ssi.response.catalog;

import com.groupa.ssi.model.domain.catalog.WorkItem;

import java.util.Date;

/**
 * @author Miguel Rojas
 * @modified by Linet Torrico
 */
public final class WorkItemResponseBuilder {

    private String name;
    private String description;

    private String type;
    private String status;
    private Date purchaseDate;

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
