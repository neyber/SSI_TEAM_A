package com.groupa.ssi.cmd.saclassification;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.saClassification.SaType;
import com.groupa.ssi.services.saClassification.SaTypeService;
import org.springframework.beans.factory.annotation.Autowired;

/*
Created on 13/5/18
@author: HENRYBC
*/
@CommandScoped
public class SaTypeReadCmd extends AbstractCommand {
    private Integer saTypeId;

    @Autowired
    private SaTypeService service;

    private SaType saType;

    @Override
    protected void run() {
        saType = service.procedureFindById(saTypeId);
    }

    public void setSaTypeId(Integer saTypeId) {
        this.saTypeId = saTypeId;
    }

    public SaType getSaType() {
        return saType;
    }
}
