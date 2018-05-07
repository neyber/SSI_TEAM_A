package com.groupa.ssi.cmd.catalog;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.catalog.WorkItemClassification;
import com.groupa.ssi.services.catalog.WorkItemClassificationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created on May 1, 2018
 * @author Walker Colina
 */
@CommandScoped
public class WorkItemClassificationListCmd extends AbstractCommand {

    @Autowired
    private WorkItemClassificationService service;

    private List<WorkItemClassification> workItemClassificationList;

    @Override
    protected void run() {
        workItemClassificationList = service.findAll();
    }

    public List<WorkItemClassification> getWorkItemClassificationList() {
        return workItemClassificationList;
    }
}
