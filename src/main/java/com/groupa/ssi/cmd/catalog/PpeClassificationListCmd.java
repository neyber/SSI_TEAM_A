package com.groupa.ssi.cmd.catalog;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.catalog.PpeClassification;
import com.groupa.ssi.services.catalog.PpeClassificationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created on April 29, 2018
 * @author Walker Colina
 */
@CommandScoped
public class PpeClassificationListCmd extends AbstractCommand {

    @Autowired
    private PpeClassificationService service;

    private List<PpeClassification> ppeClassificationList;

    @Override
    protected void run() {
        ppeClassificationList = service.findAll();
    }

    public List<PpeClassification> getPpeClassificationList() {
        return ppeClassificationList;
    }
}
