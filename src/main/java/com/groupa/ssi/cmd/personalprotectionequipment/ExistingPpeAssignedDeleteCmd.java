package com.groupa.ssi.cmd.personalprotectionequipment;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.services.personalprotectionequipment.ExistingPpeAssignedService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created on April 30, 2018
 * @author Walker Colina
 */
@CommandScoped
public class ExistingPpeAssignedDeleteCmd extends AbstractCommand {

    private Integer existingPpeAssignedId;

    @Autowired
    private ExistingPpeAssignedService service;

    @Override
    protected void run() {
        service.deleteById(existingPpeAssignedId);
    }

    public void setExistingPpeAssignedId(Integer existingPpeAssignedId) {
        this.existingPpeAssignedId = existingPpeAssignedId;
    }
}
