package com.groupa.ssi.cmd.workitem;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.workitem.ExistingWorkItem;
import com.groupa.ssi.model.domain.workitem.WorkItem;
import com.groupa.ssi.request.workitem.ExistingWorkItemRequest;
import com.groupa.ssi.services.workitem.ExistingWorkItemService;
import com.groupa.ssi.services.workitem.WorkItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created on May 1, 2018
 * @author Walker Colina
 */
@CommandScoped
public class ExistingWorkItemCreateCmd extends AbstractCommand {
    private static Logger log = LoggerFactory.getLogger(ExistingWorkItemCreateCmd.class);

    private ExistingWorkItemRequest existingWorkItemRequest;

    @Autowired
    private ExistingWorkItemService existingWorkItemService;

    @Autowired
    private WorkItemService workItemService;

    @Override
    protected void run() {
        WorkItem workItem = null;
        if(existingWorkItemRequest.getWorkItemId() != null){
            workItem = workItemService.findById(existingWorkItemRequest.getWorkItemId());
        }
        ExistingWorkItem existingWorkItem = composeExistingWorkItem(existingWorkItemRequest, workItem);
        existingWorkItemService.save(existingWorkItem);
    }

    public void setExistingWorkItemRequest(ExistingWorkItemRequest existingWorkItemRequest) {
        this.existingWorkItemRequest = existingWorkItemRequest;
    }

    private ExistingWorkItem composeExistingWorkItem(ExistingWorkItemRequest existingWorkItemRequest, WorkItem workItem){
        ExistingWorkItem existingWorkItem = new ExistingWorkItem();
        existingWorkItem.setDetail(existingWorkItemRequest.getDetail());
        existingWorkItem.setPurchaseDate(existingWorkItemRequest.getPurchaseDate());
        existingWorkItem.setSerieNo(existingWorkItemRequest.getSerieNo());
        existingWorkItem.setWorkItem(workItem);

        return existingWorkItem;
    }
}
