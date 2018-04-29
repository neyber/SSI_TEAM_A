package com.groupa.ssi.controller.catalog;

/*
Created on 28/4/18
@author: HENRYBC
*/

import com.groupa.ssi.common.response.rest.SuccessRestResponse;
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
public class SaClassificationDeleteController extends SaClassificationAbstractController{

    private SaClassificationService service;

    public SaClassificationDeleteController(SaClassificationService saClassificationService){
        this.service = saClassificationService;
    }

    @ApiOperation(value = "delete sickness/accident classification")
    @RequestMapping(
            value = "{saClassificationId}",
            method = RequestMethod.DELETE
    )
    public SuccessRestResponse deleteSaClassification(@PathVariable Integer saClassificationId,
                                                      @RequestParam(value = "userId", required = false) Integer userId){
        service.deleteById(saClassificationId);
        return new SuccessRestResponse();
    }
}
