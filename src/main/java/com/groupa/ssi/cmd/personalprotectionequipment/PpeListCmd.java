package com.groupa.ssi.cmd.personalprotectionequipment;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.personalprotectionequipment.Ppe;
import com.groupa.ssi.services.personalprotectionequipment.PpeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created on April 30, 2018
 * @author Walker Colina
 */
@CommandScoped
public class PpeListCmd extends AbstractCommand {

    @Autowired
    private PpeService service;

    private List<Ppe> ppeList;

    @Override
    protected void run() {
        ppeList = service.procedureFindAll();
    }

    public List<Ppe> getPpeList() {
        return ppeList;
    }
}
