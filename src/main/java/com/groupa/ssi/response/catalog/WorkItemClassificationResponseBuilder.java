package com.groupa.ssi.response.catalog;

import com.groupa.ssi.model.domain.catalog.WorkItemClassification;

/**
 * Created on May 1, 2018
 * @author Walker Colina
 */
public final class WorkItemClassificationResponseBuilder {

    private int id;
    private String name;
    private String description;

    private WorkItemClassificationResponseBuilder() {
    }

    public WorkItemClassificationResponse build() {
        WorkItemClassificationResponse workItemClassificationResponse = new WorkItemClassificationResponse();
        workItemClassificationResponse.setWorkItemClassificationId(id);
        workItemClassificationResponse.setName(name);
        workItemClassificationResponse.setDescription(description);

        return workItemClassificationResponse;
    }


    public static WorkItemClassificationResponseBuilder getInstance(WorkItemClassification workItemClassification) {
        return new WorkItemClassificationResponseBuilder()
                .setId(workItemClassification.getId())
                .setName(workItemClassification.getName())
                .setDescription(workItemClassification.getDescription());
    }

    public WorkItemClassificationResponseBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public WorkItemClassificationResponseBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public WorkItemClassificationResponseBuilder setDescription(String description) {
        this.description = description;
        return this;
    }
}
