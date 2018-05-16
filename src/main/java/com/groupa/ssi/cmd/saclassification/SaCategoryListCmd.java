package com.groupa.ssi.cmd.saclassification;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.saClassification.SaCategory;
import com.groupa.ssi.services.saClassification.SaCategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/*
Created on 13/5/18
@author: HENRYBC
*/
@CommandScoped
public class SaCategoryListCmd extends AbstractCommand {

    @Autowired
    private SaCategoryService service;

    private List<SaCategory> saCategoryList;

    @Override
    protected void run() {
        saCategoryList = service.findAll();
    }

    public List<SaCategory> getSaCategoryList() {
        return saCategoryList;
    }
}
