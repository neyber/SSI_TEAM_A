package com.groupa.ssi.cmd.saclassification;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.services.saClassification.SaCategoryService;
import com.groupa.ssi.services.sickness.SicknessService;
import org.springframework.beans.factory.annotation.Autowired;

/*
Created on 13/5/18
@author: HENRYBC
*/
@CommandScoped
public class SaCategoryDeleteCmd extends AbstractCommand {
    private Integer saCategoryId;

    @Autowired
    private SaCategoryService service;

    @Override
    protected void run(){
        service.procedureDeleteById(saCategoryId);
    }

    public void setSaCategoryId(Integer saCategoryId) {
        this.saCategoryId = saCategoryId;
    }
}
