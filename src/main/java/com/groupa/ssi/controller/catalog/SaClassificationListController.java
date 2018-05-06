package com.groupa.ssi.controller.catalog;

/*
Created on 28/4/18
@author: HENRYBC
*/

import com.groupa.ssi.common.response.rest.ListRestResponse;
import com.groupa.ssi.model.domain.catalog.SaClassification;
import com.groupa.ssi.response.catalog.SaClassificationResponse;
import com.groupa.ssi.services.catalog.SaClassificationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@Api(
        tags = SaClassificationAbstractController.TAG_NAME,
        description = SaClassificationAbstractController.DESCRIPTION
)
@RestController
@RequestScope
public class SaClassificationListController extends SaClassificationAbstractController{

    private SaClassificationService service;

    public SaClassificationListController(SaClassificationService saClassificationService){
        this.service = saClassificationService;
    }

    @ApiOperation(value = "list of sickness/accident classifications")
    @RequestMapping(
            method = RequestMethod.GET
    )
    public ListRestResponse<SaClassificationResponse> getSaClassificationList(@RequestParam(value = "userId", required = false) Integer userId){
        List<SaClassification> saClassificationsList = service.findAll();
        return new ListRestResponse(saClassificationsList);
    }
}
