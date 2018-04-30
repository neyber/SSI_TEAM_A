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
public class PpeClassificationUpdateCmd extends AbstractCommand {

    private Integer ppeClassificationId;
    private PpeClassificationRequest ppeClassificationRequest;

    @Autowired
    private PpeClassificationService service;

    @Override
    protected void run() {
        PpeClassification ppeClassification = composeWorkItem(ppeClassificationId, ppeClassificationRequest);
        service.save(ppeClassification);
    }

    public void setPpeClassificationId(Integer ppeClassificationId) {
        this.ppeClassificationId = ppeClassificationId;
    }

    public void setPpeClassificationRequest(PpeClassificationRequest ppeClassificationRequest) {
        this.ppeClassificationRequest = ppeClassificationRequest;
    }

    private PpeClassification composeWorkItem(Integer ppeClassificationId, PpeClassificationRequest ppeClassificationRequest) {
        PpeClassification ppeClassification = service.findById(ppeClassificationId);
        ppeClassification.setId(ppeClassificationId);
        ppeClassification.setName(ppeClassificationRequest.getName());
        ppeClassification.setDescription(ppeClassificationRequest.getDescription());

        return ppeClassification;
    }

}
