package com.groupa.ssi.cmd.saclassification;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.services.saClassification.SaCategoryService;
import com.groupa.ssi.services.saClassification.SaTypeService;
import org.springframework.beans.factory.annotation.Autowired;

/*
Created on 13/5/18
@author: HENRYBC
*/
@CommandScoped
public class SaTypeDeleteCmd extends AbstractCommand {
    private Integer saTypeId;

    @Autowired
    private SaTypeService service;

    @Override
    protected void run(){
        service.procedureDeleteById(saTypeId);
    }

    public void setSaTypeId(Integer saTypeId) {
        this.saTypeId = saTypeId;
    }
}
