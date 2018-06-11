package com.groupa.ssi.cmd.workitem;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.catalog.WorkItemClassification;
import com.groupa.ssi.model.domain.workitem.WorkItem;
import com.groupa.ssi.request.workitem.WorkItemRequest;
import com.groupa.ssi.services.catalog.WorkItemClassificationService;
import com.groupa.ssi.services.workitem.WorkItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Miguel Rojas
 */
@CommandScoped
public class WorkItemCreateCmd extends AbstractCommand {
    private static Logger log = LoggerFactory.getLogger(WorkItemCreateCmd.class);

    private WorkItemRequest workItemRequest;

    @Autowired
    private WorkItemService workItemService;

    @Autowired
    private WorkItemClassificationService workItemClassificationService;

    @Override
    protected void run() {
        WorkItemClassification workItemClassification = null;
        if(workItemRequest.getWorkItemClassificationId() != null){
            workItemClassification = workItemClassificationService.procedureFindById(workItemRequest.getWorkItemClassificationId());
        }
        WorkItem workItem = composeWorkItem(workItemRequest, workItemClassification);
        workItemService.procedureCreate(workItem);
    }

    public void setWorkItemRequest(WorkItemRequest workItemRequest) {
        this.workItemRequest = workItemRequest;
    }

    private WorkItem composeWorkItem(WorkItemRequest workItemRequest, WorkItemClassification workItemClassification) {
        WorkItem workItem = new WorkItem();
        workItem.setName(workItemRequest.getName());
        workItem.setDescription(workItemRequest.getDescription());
        workItem.setWorkItemClassification(workItemClassification);

        return workItem;
    }
}
