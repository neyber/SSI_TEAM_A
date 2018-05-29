package com.groupa.ssi.cmd.catalog;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.catalog.WorkItemClassification;
import com.groupa.ssi.services.catalog.WorkItemClassificationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created on May 1, 2018
 * @author Walker Colina
 */
@CommandScoped
public class WorkItemClassificationListCmd extends AbstractCommand {

    @Autowired
    private WorkItemClassificationService service;

    private List<WorkItemClassification> workItemClassificationList;

    @Override
    protected void run() {
        workItemClassificationList = service.findAll();

/*
        System.out.println("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");
        System.out.println("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");
        System.out.println("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD" + service.getAll());

        for (WorkItemClassification workItemClassification : service.getAll()) {
            System.out.println("ZZZZZZZZZZZZZZ: "+ workItemClassification.getId());
            System.out.println("ZZZZZZZZZZZZZZ: "+ workItemClassification.getName());
            System.out.println("ZZZZZZZZZZZZZZ: "+ workItemClassification.getDescription());
            System.out.println("ZZZZZZZZZZZZZZ: "+ workItemClassification.getCreatedOn());
            System.out.println("---------------------------------------------------");
        }
*/

    }

    public List<WorkItemClassification> getWorkItemClassificationList() {
        return workItemClassificationList;
    }
}
