package com.groupa.ssi.cmd.functionmanual;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.services.catalog.WorkItemService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Miguel Rojas
 */
@CommandScoped
public class WorkItemDeleteCmd extends AbstractCommand {

    private Integer workItemId;

    @Autowired
    private WorkItemService service;

    @Override
    protected void run() {
        service.deleteById(workItemId);
    }

    public void setWorkItemId(Integer workItemId) {
        this.workItemId = workItemId;
    }
}
