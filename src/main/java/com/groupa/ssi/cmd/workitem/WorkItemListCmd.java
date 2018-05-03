package com.groupa.ssi.cmd.workitem;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.workitem.WorkItem;
import com.groupa.ssi.services.workitem.WorkItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Miguel Rojas
 */
@CommandScoped
public class WorkItemListCmd extends AbstractCommand {
    private static Logger log = LoggerFactory.getLogger(WorkItemListCmd.class);

    @Autowired
    private WorkItemService service;

    private List<WorkItem> workItemList;

    @Override
    protected void run() {
        workItemList = service.findAll();
    }

    public List<WorkItem> getWorkItemList() {
        return workItemList;
    }
}
