package com.groupa.ssi.cmd.catalog;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.catalog.PpeClassification;
import com.groupa.ssi.services.catalog.PpeClassificationService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created on April 29, 2018
 * @author Walker Colina
 */
@CommandScoped
public class PpeClassificationReadCmd extends AbstractCommand {

    private Integer ppeClassificationId;

    @Autowired
    private PpeClassificationService service;

    private PpeClassification ppeClassification;

    @Override
    protected void run() {
        ppeClassification = service.procedureFindById(ppeClassificationId);
    }

    public void setPpeClassificationId(Integer ppeClassificationId) {
        this.ppeClassificationId = ppeClassificationId;
    }

    public PpeClassification getPpeClassification() {
        return ppeClassification;
    }
}
