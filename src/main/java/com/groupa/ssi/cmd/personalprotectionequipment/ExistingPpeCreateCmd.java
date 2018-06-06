package com.groupa.ssi.cmd.personalprotectionequipment;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.personalprotectionequipment.ExistingPpe;
import com.groupa.ssi.model.domain.personalprotectionequipment.Ppe;
import com.groupa.ssi.request.personalprotectionequipment.ExistingPpeRequest;
import com.groupa.ssi.services.personalprotectionequipment.ExistingPpeService;
import com.groupa.ssi.services.personalprotectionequipment.PpeService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created on April 26, 2018
 * @author Walker Colina
 */
@CommandScoped
public class ExistingPpeCreateCmd extends AbstractCommand {

    private ExistingPpeRequest existingPpeRequest;

    @Autowired
    private ExistingPpeService existingPpeService;

    @Autowired
    private PpeService ppeService;

    @Override
    protected void run() {
        Ppe ppe = null;
        if(existingPpeRequest.getPpeId() != null){
            ppe = ppeService.procedureFindById(existingPpeRequest.getPpeId());
        }
        ExistingPpe existingPpe = composeExistingPpe(existingPpeRequest, ppe);
        existingPpeService.procedureCreate(existingPpe);
    }

    public void setExistingPpeRequest(ExistingPpeRequest existingPpeRequest) {
        this.existingPpeRequest = existingPpeRequest;
    }

    private ExistingPpe composeExistingPpe(ExistingPpeRequest existingPpeRequest, Ppe ppe){
        ExistingPpe existingPpe = new ExistingPpe();
        existingPpe.setDetail(existingPpeRequest.getDetail());
        existingPpe.setPurchaseDate(existingPpeRequest.getPurchaseDate());
        existingPpe.setLifeTimeDays(existingPpeRequest.getLifeTimeDays());
        existingPpe.setCurrentLifeTimeDays(existingPpeRequest.getCurrentLifeTimeDays());
        existingPpe.setPpe(ppe);

        return existingPpe;
    }
}
