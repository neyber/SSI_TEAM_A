package com.groupa.ssi.cmd.catalog;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.catalog.WorkItem;
import com.groupa.ssi.services.catalog.WorkItemService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Miguel Rojas
 */
@CommandScoped
public class WorkItemListCmd extends AbstractCommand {

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
