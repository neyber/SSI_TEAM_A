package com.groupa.ssi.cmd.functionmanual;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.catalog.WorkItem;
import com.groupa.ssi.services.catalog.WorkItemService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Miguel Rojas
 */
@CommandScoped
public class WorkItemReadCmd extends AbstractCommand {

    private Integer workItemId;

    @Autowired
    private WorkItemService service;

    private WorkItem workItem;

    @Override
    protected void run() {
        workItem = service.findById(workItemId);
    }

    public void setWorkItemId(Integer workItemId) {
        this.workItemId = workItemId;
    }

    public WorkItem getWorkItem() {
        return workItem;
    }
}
