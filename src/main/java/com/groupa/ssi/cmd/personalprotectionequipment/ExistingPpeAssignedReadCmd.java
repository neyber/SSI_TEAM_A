package com.groupa.ssi.cmd.personalprotectionequipment;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.personalprotectionequipment.ExistingPpeAssigned;
import com.groupa.ssi.services.personalprotectionequipment.ExistingPpeAssignedService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created on April 30, 2018
 * @author Walker Colina
 */
@CommandScoped
public class ExistingPpeAssignedReadCmd extends AbstractCommand {

    private Integer existingPpeAssignedId;

    @Autowired
    private ExistingPpeAssignedService service;

    private ExistingPpeAssigned existingPpeAssigned;

    @Override
    protected void run() {
        existingPpeAssigned = service.findById(existingPpeAssignedId);
    }

    public void setExistingPpeAssignedId(Integer existingPpeAssignedId) {
        this.existingPpeAssignedId = existingPpeAssignedId;
    }

    public ExistingPpeAssigned getExistingPpeAssigned() {
        return existingPpeAssigned;
    }
}
