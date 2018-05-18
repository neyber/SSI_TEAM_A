package com.groupa.ssi.cmd.saclassification;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.saClassification.SaCategory;
import com.groupa.ssi.services.saClassification.SaCategoryService;
import org.springframework.beans.factory.annotation.Autowired;

/*
Created on 13/5/18
@author: HENRYBC
*/
@CommandScoped
public class SaCategoryReadCmd extends AbstractCommand {
    private Integer saCategoryId;

    @Autowired
    private SaCategoryService service;

    private SaCategory saCategory;

    @Override
    protected void run() {
        saCategory = service.findById(saCategoryId);
    }

    public void setSaCategoryId(Integer saCategoryId) {
        this.saCategoryId = saCategoryId;
    }

    public SaCategory getSaCategory() {
        return saCategory;
    }
}
