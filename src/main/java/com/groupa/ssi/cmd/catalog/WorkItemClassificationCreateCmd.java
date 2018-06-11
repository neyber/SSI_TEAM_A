package com.groupa.ssi.cmd.catalog;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.catalog.WorkItemClassification;
import com.groupa.ssi.request.catalog.WorkItemClassificationRequest;
import com.groupa.ssi.services.catalog.WorkItemClassificationService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created on May 1, 2018
 * @author Walker Colina
 */
@CommandScoped
public class WorkItemClassificationCreateCmd extends AbstractCommand {

    private WorkItemClassificationRequest workItemClassificationRequest;

    @Autowired
    private WorkItemClassificationService service;

    @Override
    protected void run() {
        WorkItemClassification workItemClassification = composeWorkItemClassification(workItemClassificationRequest);
        service.procedureCreate(workItemClassification);
    }

    public void setWorkItemClassificationRequest(WorkItemClassificationRequest workItemClassificationRequest) {
        this.workItemClassificationRequest = workItemClassificationRequest;
    }

    private WorkItemClassification composeWorkItemClassification(WorkItemClassificationRequest workItemClassificationRequest) {
        WorkItemClassification workItemClassification = new WorkItemClassification();
        workItemClassification.setName(workItemClassificationRequest.getName());
        workItemClassification.setDescription(workItemClassificationRequest.getDescription());

        return workItemClassification;
    }
}
