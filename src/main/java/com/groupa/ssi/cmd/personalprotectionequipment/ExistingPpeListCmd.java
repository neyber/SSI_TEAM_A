package com.groupa.ssi.cmd.personalprotectionequipment;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.personalprotectionequipment.ExistingPpe;
import com.groupa.ssi.services.personalprotectionequipment.ExistingPpeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created on April 26, 2018
 * @author Walker Colina
 */
@CommandScoped
public class ExistingPpeListCmd extends AbstractCommand {

    @Autowired
    private ExistingPpeService service;

    private List<ExistingPpe> existingPpeList;

    @Override
    protected void run() {
        existingPpeList = service.findAll();
    }

    public List<ExistingPpe> getExistingPpeList() {
        return existingPpeList;
    }
}
