package com.groupa.ssi.cmd.catalog;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.services.catalog.WorkItemClassificationService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created on May 1, 2018
 * @author Walker Colina
 */
@CommandScoped
public class WorkItemClassificationDeleteCmd extends AbstractCommand {

    private Integer workItemClassificationId;

    @Autowired
    private WorkItemClassificationService service;

    @Override
    protected void run() {
        service.procedureDeleteById(workItemClassificationId);
    }

    public void setWorkItemClassificationId(Integer workItemClassificationId) {
        this.workItemClassificationId = workItemClassificationId;
    }
}
