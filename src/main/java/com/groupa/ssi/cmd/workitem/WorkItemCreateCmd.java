package com.groupa.ssi.cmd.workitem;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.workitem.WorkItem;
import com.groupa.ssi.request.workitem.WorkItemRequest;
import com.groupa.ssi.services.workitem.WorkItemService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Miguel Rojas
 */
@CommandScoped
public class WorkItemCreateCmd extends AbstractCommand {

    private WorkItemRequest workItemRequest;

    @Autowired
    private WorkItemService service;

    @Override
    protected void run() {
        WorkItem workItem = composeWorkItem(workItemRequest);
        service.save(workItem);
    }

    public void setWorkItemRequest(WorkItemRequest workItemRequest) {
        this.workItemRequest = workItemRequest;
    }

    private WorkItem composeWorkItem(WorkItemRequest workItemRequest) {
        WorkItem workItem = new WorkItem();
        workItem.setName(workItemRequest.getName());
        workItem.setDescription(workItemRequest.getDescription());
        workItem.setPurchaseDate(workItemRequest.getPurchaseDate());
        workItem.setSerieNo(workItemRequest.getSerieNo());
        workItem.setStatus(workItemRequest.getStatus());
        workItem.setType(workItemRequest.getType());

        return workItem;
    }
}
