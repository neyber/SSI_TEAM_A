package com.groupa.ssi.cmd.saclassification;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.saClassification.SaType;
import com.groupa.ssi.services.saClassification.SaTypeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/*
Created on 13/5/18
@author: HENRYBC
*/
@CommandScoped
public class SaTypeListCmd extends AbstractCommand {
    @Autowired
    private SaTypeService service;

    private List<SaType> saTypeList;

    @Override
    protected void run() {
        saTypeList = service.procedureFindAll();
    }

    public List<SaType> getSaTypeList() {
        return saTypeList;
    }
}
