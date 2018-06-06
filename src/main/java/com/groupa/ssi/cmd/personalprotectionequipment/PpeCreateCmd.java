package com.groupa.ssi.cmd.personalprotectionequipment;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.catalog.PpeClassification;
import com.groupa.ssi.model.domain.personalprotectionequipment.Ppe;
import com.groupa.ssi.request.personalprotectionequipment.PpeRequest;
import com.groupa.ssi.services.catalog.PpeClassificationService;
import com.groupa.ssi.services.personalprotectionequipment.PpeService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created on April 30, 2018
 * @author Walker Colina
 */
@CommandScoped
public class PpeCreateCmd extends AbstractCommand {

    private PpeRequest ppeRequest;

    @Autowired
    private PpeService ppeService;

    @Autowired
    private PpeClassificationService ppeClassificationService;

    @Override
    protected void run() {
        PpeClassification ppeClassification = null;
        if(ppeRequest.getPpeClassificationId() != null){
            ppeClassification = ppeClassificationService.procedureFindById(ppeRequest.getPpeClassificationId());
        }
        Ppe ppe = composePpe(ppeRequest, ppeClassification);
        ppeService.procedureCreate(ppe);
    }

    public void setPpeRequest(PpeRequest ppeRequest) {
        this.ppeRequest = ppeRequest;
    }

    private Ppe composePpe(PpeRequest ppeRequest, PpeClassification ppeClassification) {
        Ppe ppe = new Ppe();
        ppe.setName(ppeRequest.getName());
        ppe.setDescription(ppeRequest.getDescription());
        //ppe.setImage(ppeRequest.getImage());
        ppe.setPpeClassification(ppeClassification);

        return ppe;
    }
}
