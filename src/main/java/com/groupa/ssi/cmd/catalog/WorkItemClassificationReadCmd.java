package com.groupa.ssi.cmd.catalog;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.catalog.WorkItemClassification;
import com.groupa.ssi.services.catalog.WorkItemClassificationService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created on May 1, 2018
 * @author Walker Colina
 */
@CommandScoped
public class WorkItemClassificationReadCmd extends AbstractCommand {

    private Integer workIemClassificationId;

    @Autowired
    private WorkItemClassificationService service;

    private WorkItemClassification workItemClassification;

    @Override
    protected void run() {
        workItemClassification = service.procedureFindById(workIemClassificationId);
    }

    public void setWorkItemClassificationId(Integer workIemClassificationId) {
        this.workIemClassificationId = workIemClassificationId;
    }

    public WorkItemClassification getWorkItemClassification() {
        return workItemClassification;
    }
}
