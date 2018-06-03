package com.groupa.ssi.cmd.workitem;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.workitem.ExistingWorkItem;
import com.groupa.ssi.services.workitem.ExistingWorkItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created on May 1, 2018
 * @author Walker Colina
 */
@CommandScoped
public class ExistingWorkItemListCmd extends AbstractCommand {
    private static Logger log = LoggerFactory.getLogger(ExistingWorkItemListCmd.class);

    @Autowired
    private ExistingWorkItemService service;

    private List<ExistingWorkItem> existingWorkItemList;

    @Override
    protected void run() {
        existingWorkItemList = service.procedureFindAll();
    }

    public List<ExistingWorkItem> getExistingWorkItemList() {
        return existingWorkItemList;
    }
}
