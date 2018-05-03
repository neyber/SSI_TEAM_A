package com.groupa.ssi.cmd.personalprotectionequipment;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.personalprotectionequipment.Ppe;
import com.groupa.ssi.services.personalprotectionequipment.PpeService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created on April 30, 2018
 * @author Walker Colina
 */
@CommandScoped
public class PpeReadCmd extends AbstractCommand {

    private Integer ppeId;

    @Autowired
    private PpeService service;

    private Ppe ppe;

    @Override
    protected void run() {
        ppe = service.findById(ppeId);
    }

    public void setPpeId(Integer ppeId) {
        this.ppeId = ppeId;
    }

    public Ppe getPpe() {
        return ppe;
    }
}
