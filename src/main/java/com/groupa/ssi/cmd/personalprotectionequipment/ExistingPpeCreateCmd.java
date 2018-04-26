package com.groupa.ssi.cmd.personalprotectionequipment;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.personalprotectionequipment.ExistingPpe;
import com.groupa.ssi.request.personalprotectionequipment.ExistingPpeRequest;
import com.groupa.ssi.services.personalprotectionequipment.ExistingPpeService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created on April 26, 2018
 * @author Walker Colina
 */
@CommandScoped
public class ExistingPpeCreateCmd extends AbstractCommand {

    private ExistingPpeRequest existingPpeRequest;

    @Autowired
    private ExistingPpeService service;

    @Override
    protected void run() {
        ExistingPpe existingPpe = composeExistingPpe(existingPpeRequest);
        service.save(existingPpe);
    }

    public void setExistingPpeRequest(ExistingPpeRequest existingPpeRequest) {
        this.existingPpeRequest = existingPpeRequest;
    }

    private ExistingPpe composeExistingPpe(ExistingPpeRequest existingPpeRequest){
        ExistingPpe existingPpe = new ExistingPpe();
        existingPpe.setDetail(existingPpeRequest.getDetail());
        existingPpe.setPurchaseDate(existingPpeRequest.getPurchaseDate());
        existingPpe.setLifeTimeDays(existingPpeRequest.getLifeTimeDays());
        existingPpe.setCurrentLifeTimeDays(existingPpeRequest.getCurrentLifeTimeDays());
        existingPpe.setPpe(existingPpeRequest.getPpe());

        return existingPpe;
    }
}
