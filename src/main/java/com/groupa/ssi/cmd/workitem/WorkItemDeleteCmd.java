package com.groupa.ssi.cmd.workitem;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.services.workitem.WorkItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Miguel Rojas
 */
@CommandScoped
public class WorkItemDeleteCmd extends AbstractCommand {
    private static Logger log = LoggerFactory.getLogger(WorkItemDeleteCmd.class);

    private Integer workItemId;

    @Autowired
    private WorkItemService service;

    @Override
    protected void run() {
        service.procedureDeleteById(workItemId);
    }

    public void setWorkItemId(Integer workItemId) {
        this.workItemId = workItemId;
    }
}
