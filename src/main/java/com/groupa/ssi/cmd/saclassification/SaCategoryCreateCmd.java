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
public class SaCategoryCreateCmd extends AbstractCommand {

    private SaCategoryRequest saCategoryRequest;

    @Autowired
    private SaCategoryService saCategoryService;

    @Override
    protected void run(){
        SaCategory saCategory = this.composeSaCategory(saCategoryRequest);
        saCategoryService.save(saCategory);
    }

    public void setSaCategoryRequest(SaCategoryRequest saCategoryRequest) {
        this.saCategoryRequest = saCategoryRequest;
    }

    private SaCategory composeSaCategory(SaCategoryRequest saCategoryRequest) {
        SaCategory saCategory = new SaCategory();
        saCategory.setCategory(saCategoryRequest.getCategory());
        saCategory.setDescription(saCategoryRequest.getDescription());
        saCategory.setReference(saCategoryRequest.getReference());

        return saCategory;
    }
}
