package com.groupa.ssi.cmd.catalog;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.catalog.PpeClassification;
import com.groupa.ssi.model.domain.catalog.WorkItemClassification;
import com.groupa.ssi.request.catalog.PpeClassificationRequest;
import com.groupa.ssi.request.catalog.WorkItemClassificationRequest;
import com.groupa.ssi.services.catalog.WorkItemClassificationService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created on May 1, 2018
 * @author Walker Colina
 */
@CommandScoped
public class WorkItemClassificationUpdateCmd extends AbstractCommand {

    private Integer workItemClassificationId;
    private WorkItemClassificationRequest workItemClassificationRequest;

    @Autowired
    private WorkItemClassificationService service;

    @Override
    protected void run() {
        WorkItemClassification workItemClassification = composeWorkItemClassification(workItemClassificationId, workItemClassificationRequest);
        service.procedureUpdate(workItemClassification);
    }

    public void setWorkItemClassificationId(Integer workItemClassificationId) {
        this.workItemClassificationId = workItemClassificationId;
    }

    public void setWorkItemClassificationRequest(WorkItemClassificationRequest workItemClassificationRequest) {
        this.workItemClassificationRequest = workItemClassificationRequest;
    }

    private WorkItemClassification composeWorkItemClassification(Integer workItemClassificationId, WorkItemClassificationRequest workItemClassificationRequest) {
        WorkItemClassification workItemClassification = service.procedureFindById(workItemClassificationId);
        workItemClassification.setName(workItemClassificationRequest.getName());
        workItemClassification.setDescription(workItemClassificationRequest.getDescription());

        return workItemClassification;
    }

}
