package com.groupa.ssi.controller.catalog;

/*
Created on 28/4/18
@author: HENRYBC
*/

import com.groupa.ssi.common.response.rest.SingleRestResponse;
import com.groupa.ssi.model.domain.catalog.SaClassification;
import com.groupa.ssi.response.catalog.SaClassificationResponse;
import com.groupa.ssi.response.catalog.SaClassificationResponseBuilder;
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
public class SaClassificationReadController extends SaClassificationAbstractController{

    private SaClassificationService service;

    public SaClassificationReadController(SaClassificationService service){
        this.service = service;
    }

    @ApiOperation(value = "list of sickness/accident classifications")
    @RequestMapping(
            value = "{saClassificationId}",
            method = RequestMethod.GET
    )
    public SingleRestResponse<SaClassificationResponse> readSaClassification(@PathVariable Integer saClassificationId,
                                                                             @RequestParam(value = "userId", required = false) Integer userId){
        SaClassification saClassification = service.findById(saClassificationId);
        return new SingleRestResponse(SaClassificationResponseBuilder.getInstance(saClassification).build());
    }
}
