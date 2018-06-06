package com.groupa.ssi.cmd.saclassification;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.saClassification.SaCategory;
import com.groupa.ssi.request.saclassification.SaCategoryRequest;
import com.groupa.ssi.services.saClassification.SaCategoryService;
import org.springframework.beans.factory.annotation.Autowired;

/*
Created on 13/5/18
@author: HENRYBC
*/
@CommandScoped
public class SaCategoryUpdateCmd extends AbstractCommand {

    private Integer saCategoryId;
    private SaCategoryRequest saCategoryRequest;

    @Autowired
    private SaCategoryService service;

    @Override
    protected void run() {
        SaCategory saCategory = composeSaCategory(saCategoryRequest);
        service.procedureUpdate(saCategory);
    }

    public void setSaCategoryId(Integer saCategoryId) {
        this.saCategoryId = saCategoryId;
    }

    public void setSaCategoryRequest(SaCategoryRequest saCategoryRequest) {
        this.saCategoryRequest = saCategoryRequest;
    }

    private SaCategory composeSaCategory(SaCategoryRequest saCategoryRequest) {
        SaCategory saCategory = service.procedureFindById(saCategoryId);
        saCategory.setCategory(saCategoryRequest.getCategory());
        saCategory.setDescription(saCategoryRequest.getDescription());
        saCategory.setReference(saCategoryRequest.getReference());

        return saCategory;
    }
}
