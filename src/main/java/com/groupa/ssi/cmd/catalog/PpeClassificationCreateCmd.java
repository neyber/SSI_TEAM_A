package com.groupa.ssi.cmd.catalog;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.catalog.PpeClassification;
import com.groupa.ssi.request.catalog.PpeClassificationRequest;
import com.groupa.ssi.services.catalog.PpeClassificationService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created on April 29, 2018
 * @author Walker Colina
 */
@CommandScoped
public class PpeClassificationCreateCmd extends AbstractCommand {

    private PpeClassificationRequest ppeClassificationRequest;

    @Autowired
    private PpeClassificationService service;

    @Override
    protected void run() {
        PpeClassification ppeClassification = composePpeClassification(ppeClassificationRequest);
        service.save(ppeClassification);
    }

    public void setPpeClassificationRequest(PpeClassificationRequest ppeClassificationRequest) {
        this.ppeClassificationRequest = ppeClassificationRequest;
    }

    private PpeClassification composePpeClassification(PpeClassificationRequest ppeClassificationRequest) {
        PpeClassification ppeClassification = new PpeClassification();
        ppeClassification.setName(ppeClassificationRequest.getName());
        ppeClassification.setDescription(ppeClassificationRequest.getDescription());

        return ppeClassification;
    }
}
