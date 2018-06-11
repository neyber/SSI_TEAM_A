package com.groupa.ssi.cmd.catalog;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.services.catalog.PpeClassificationService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created on April 29, 2018
 * @author Walker Colina
 */
@CommandScoped
public class PpeClassificationDeleteCmd extends AbstractCommand {

    private Integer ppeClassificationId;

    @Autowired
    private PpeClassificationService service;

    @Override
    protected void run() {
        service.procedureDeleteById(ppeClassificationId);
    }

    public void setPpeClassificationId(Integer ppeClassificationId) {
        this.ppeClassificationId = ppeClassificationId;
    }
}
