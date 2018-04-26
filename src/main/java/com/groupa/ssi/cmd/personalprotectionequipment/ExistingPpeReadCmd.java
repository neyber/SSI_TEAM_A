package com.groupa.ssi.cmd.personalprotectionequipment;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.personalprotectionequipment.ExistingPpe;
import com.groupa.ssi.services.personalprotectionequipment.ExistingPpeService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created on April 26, 2018
 * @author Walker Colina
 */
@CommandScoped
public class ExistingPpeReadCmd extends AbstractCommand {

    private Integer existingPpeId;

    @Autowired
    private ExistingPpeService service;

    private ExistingPpe existingPpe;

    @Override
    protected void run() {
        existingPpe = service.findById(existingPpeId);
    }

    public void setExistingPpeId(Integer existingPpeId) {
        this.existingPpeId = existingPpeId;
    }

    public ExistingPpe getExistingPpe() {
        return existingPpe;
    }
}
