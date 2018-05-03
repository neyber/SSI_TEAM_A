package com.groupa.ssi.cmd.personalprotectionequipment;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.personalprotectionequipment.ExistingPpeAssigned;
import com.groupa.ssi.services.personalprotectionequipment.ExistingPpeAssignedService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created on April 30, 2018
 * @author Walker Colina
 */
@CommandScoped
public class ExistingPpeAssignedListCmd extends AbstractCommand {

    @Autowired
    private ExistingPpeAssignedService service;

    private List<ExistingPpeAssigned> existingPpeAssignedList;

    @Override
    protected void run() {
        existingPpeAssignedList = service.findAll();
    }

    public List<ExistingPpeAssigned> getExistingPpeAssignedList() {
        return existingPpeAssignedList;
    }
}
