package com.groupa.ssi.cmd.workitem;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.workitem.ExistingWorkItem;
import com.groupa.ssi.services.workitem.ExistingWorkItemService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created on May 1, 2018
 * @author Walker Colina
 */
@CommandScoped
public class ExistingWorkItemReadCmd extends AbstractCommand {

    private Integer existingWorkItemId;

    @Autowired
    private ExistingWorkItemService service;

    private ExistingWorkItem existingWorkItem;

    @Override
    protected void run() {
        existingWorkItem = service.findById(existingWorkItemId);
    }

    public void setExistingWorkItemId(Integer existingWorkItemId) {
        this.existingWorkItemId = existingWorkItemId;
    }

    public ExistingWorkItem getExistingWorkItem() {
        return existingWorkItem;
    }
}
