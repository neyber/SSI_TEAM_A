package com.groupa.ssi.cmd.workitem;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.services.workitem.ExistingWorkItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created on May 1, 2018
 * @author Walker Colina
 */
@CommandScoped
public class ExistingWorkItemDeleteCmd extends AbstractCommand {
    private static Logger log = LoggerFactory.getLogger(ExistingWorkItemDeleteCmd.class);

    private Integer existingWorkItemId;

    @Autowired
    private ExistingWorkItemService service;

    @Override
    protected void run() {
        service.deleteById(existingWorkItemId);
    }

    public void setExistingWorkItemId(Integer existingWorkItemId) {
        this.existingWorkItemId = existingWorkItemId;
    }
}
