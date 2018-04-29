package com.groupa.ssi.cmd.functionmanual;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.catalog.WorkItem;
import com.groupa.ssi.request.catalog.WorkItemRequest;
import com.groupa.ssi.services.catalog.WorkItemService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Miguel Rojas
 */
@CommandScoped
public class WorkItemUpdateCmd extends AbstractCommand {

    private Integer workItemId;
    private WorkItemRequest workItemRequest;

    @Autowired
    private WorkItemService service;

    @Override
    protected void run() {
        WorkItem workItem = composeWorkItem(workItemId, workItemRequest);
        service.save(workItem);
    }

    public void setWorkItemId(Integer workItemId) {
        this.workItemId = workItemId;
    }

    public void setWorkItemRequest(WorkItemRequest workItemRequest) {
        this.workItemRequest = workItemRequest;
    }

    private WorkItem composeWorkItem(Integer workItemId, WorkItemRequest workItemRequest) {
        WorkItem workItem = service.findById(workItemId);
        workItem.setWorkItemId(workItemId);
        workItem.setName(workItemRequest.getName());
        workItem.setDescription(workItemRequest.getDescription());
        workItem.setPurchaseDate(workItemRequest.getPurchaseDate());
        workItem.setSerieNo(workItemRequest.getSerieNo());
        workItem.setStatus(workItemRequest.getStatus());
        workItem.setType(workItemRequest.getType());

        return workItem;
    }

}
