package com.groupa.ssi.controller.saclassification;

import com.groupa.ssi.cmd.saclassification.SaTypeReadCmd;
import com.groupa.ssi.common.response.rest.SingleRestResponse;
import com.groupa.ssi.response.saClassification.SaTypeResponse;
import com.groupa.ssi.response.saClassification.SaTypeResponseBuilder;
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
public class SaTypeReadController extends SaTypeAbstractController {

    @Autowired
    private SaTypeReadCmd cmd;

    @ApiOperation(value = "Read a sickness/accident Types")
    @RequestMapping(
            value = "/{saTypeId}",
            method = RequestMethod.GET
    )
    public SingleRestResponse<SaTypeResponse> readSaType(@PathVariable Integer saTypeId,
                                                         @RequestParam(value = "userId", required = false) Integer userId) {
        cmd.setSaTypeId(saTypeId);
        cmd.execute();
        return new SingleRestResponse(SaTypeResponseBuilder.getIsntance(cmd.getSaType()).build());
    }
}
