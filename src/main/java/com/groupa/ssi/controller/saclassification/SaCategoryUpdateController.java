package com.groupa.ssi.controller.saclassification;

import com.groupa.ssi.cmd.saclassification.SaCategoryUpdateCmd;
import com.groupa.ssi.common.response.rest.SuccessRestResponse;
import com.groupa.ssi.request.saclassification.SaCategoryRequest;
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
        tags = SaCategoryAbstractController.TAG_NAME,
        description = SaCategoryAbstractController.DESCRIPTION
)
@RestController
@RequestScope
public class SaCategoryUpdateController extends SaCategoryAbstractController {
    @Autowired
    private SaCategoryUpdateCmd cmd;

    @ApiOperation(value = "Update sickness/accident category")
    @RequestMapping(
            value = "/{saCategoryId}",
            method = RequestMethod.PUT
    )
    public SuccessRestResponse updateSaCategory(@PathVariable Integer saCategoryId,
                                                @RequestBody SaCategoryRequest saCategoryRequest,
                                                @RequestParam(value = "userId") Integer userId) {
        cmd.setSaCategoryId(saCategoryId);
        cmd.setSaCategoryRequest(saCategoryRequest);
        cmd.execute();
        return new SuccessRestResponse();
    }
}
