package com.groupa.ssi.cmd.saclassification;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.saClassification.SaType;
import com.groupa.ssi.request.saclassification.SaTypeRequest;
import com.groupa.ssi.services.saClassification.SaTypeService;
import org.springframework.beans.factory.annotation.Autowired;

/*
Created on 13/5/18
@author: HENRYBC
*/
@CommandScoped
public class SaTypeUpdateCmd extends AbstractCommand {

    private Integer saTypeId;
    private SaTypeRequest saTypeRequest;

    @Autowired
    private SaTypeService service;

    @Override
    protected void run() {
        SaType saType = composeSaType(saTypeRequest);
        service.save(saType);
    }

    public void setSaTypeId(Integer saTypeId) {
        this.saTypeId = saTypeId;
    }

    public void setSaTypeRequest(SaTypeRequest saTypeRequest) {
        this.saTypeRequest = saTypeRequest;
    }

    private SaType composeSaType(SaTypeRequest saTypeRequest) {
        SaType saType = new SaType();
        saType.setType(saTypeRequest.getType());
        saType.setDescription(saTypeRequest.getDescription());

        return saType;
    }
}
