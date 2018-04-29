package com.groupa.ssi.controller.catalog;

/*
Created on 28/4/18
@author: HENRYBC
*/

import com.groupa.ssi.common.response.rest.SuccessRestResponse;
import com.groupa.ssi.model.domain.catalog.SaClassification;
import com.groupa.ssi.request.catalog.SaClassificationRequest;
import com.groupa.ssi.services.catalog.SaClassificationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

@Api(
        tags = SaClassificationAbstractController.TAG_NAME,
        description = SaClassificationAbstractController.DESCRIPTION
)
@RestController
@RequestScope
public class SaClassificationCreateController extends SaClassificationAbstractController{

    private SaClassificationService service;

    public SaClassificationCreateController(SaClassificationService saClassificationService){
        this.service = saClassificationService;
    }

    @ApiOperation(value = "create sickness/accident classification")
    @RequestMapping(
            method = RequestMethod.POST
    )
    public SuccessRestResponse createSaClassification(@RequestBody SaClassificationRequest saClassificationRequest,
                                                      @RequestParam(value = "userId", required = false) Integer userId){
        SaClassification saClassification = new SaClassification();
        saClassification.setCategory(saClassificationRequest.getCategory());
        saClassification.setTotalDaysOutOfWork(saClassificationRequest.getTotalDaysOutOfWork());
        saClassification.setTotalDaysRestrictedTransferredWork(saClassificationRequest.getTotalDaysRestrictedTransferredWork());
        saClassification.setType(saClassificationRequest.getType());
        service.save(saClassification);

        return new SuccessRestResponse();
    }

}
