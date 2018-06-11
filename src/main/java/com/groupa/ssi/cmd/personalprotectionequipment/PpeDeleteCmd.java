package com.groupa.ssi.cmd.personalprotectionequipment;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.services.personalprotectionequipment.PpeService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created on April 30, 2018
 * @author Walker Colina
 */
@CommandScoped
public class PpeDeleteCmd extends AbstractCommand {

    private Integer ppeId;

    @Autowired
    private PpeService service;

    @Override
    protected void run() {
        service.procedureDeleteById(ppeId);
    }

    public void setPpeId(Integer ppeId) {
        this.ppeId = ppeId;
    }
}
