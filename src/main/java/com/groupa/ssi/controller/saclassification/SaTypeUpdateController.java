package com.groupa.ssi.controller.saclassification;

import com.groupa.ssi.cmd.saclassification.SaTypeUpdateCmd;
import com.groupa.ssi.common.response.rest.SuccessRestResponse;
import com.groupa.ssi.request.saclassification.SaTypeRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

/*
Created on 13/5/18
@author: HENRYBC
*/
@Api(
        tags = SaTypeAbstractController.TAG_NAME,
        description = SaTypeAbstractController.DESCRIPTION
)
@RestController
@RequestScope
public class SaTypeUpdateController extends SaTypeAbstractController {

    @Autowired
    private SaTypeUpdateCmd cmd;

    @ApiOperation(value = "Update sickness/accident type")
    @RequestMapping(
            value = "/{saTypeId}",
            method = RequestMethod.PUT
    )
    public SuccessRestResponse updateSaType(@PathVariable Integer saTypeId,
                                            @RequestBody SaTypeRequest saTypeRequest,
                                            @RequestParam(value = "userId") Integer userId) {
        cmd.setSaTypeId(saTypeId);
        cmd.setSaTypeRequest(saTypeRequest);
        cmd.execute();
        return new SuccessRestResponse();
    }
}
