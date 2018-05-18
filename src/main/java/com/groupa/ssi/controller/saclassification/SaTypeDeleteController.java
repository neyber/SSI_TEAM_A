package com.groupa.ssi.controller.saclassification;

/*
Created on 13/5/18
@author: HENRYBC
*/

import com.groupa.ssi.cmd.saclassification.SaTypeDeleteCmd;
import com.groupa.ssi.common.response.rest.SuccessRestResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

@Api(
        tags = SaTypeAbstractController.TAG_NAME,
        description = SaTypeAbstractController.DESCRIPTION
)
@RestController
@RequestScope
public class SaTypeDeleteController extends SaTypeAbstractController{
    @Autowired
    private SaTypeDeleteCmd cmd;

    @ApiOperation(value = "delete saType")
    @RequestMapping(
            value = "/{saTypeId}",
            method = RequestMethod.DELETE
    )
    public SuccessRestResponse deleteSaCategory(@PathVariable Integer saTypeId,
                                                @RequestParam(value = "userId", required = false) Integer userId) {

        cmd.setSaTypeId(saTypeId);
        cmd.execute();
        return new SuccessRestResponse();

    }
}
