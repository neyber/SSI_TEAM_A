package com.groupa.ssi.controller.saclassification;

import com.groupa.ssi.cmd.saclassification.SaCategoryReadCmd;
import com.groupa.ssi.common.response.rest.SingleRestResponse;
import com.groupa.ssi.response.saClassification.SaCategoryResponse;
import com.groupa.ssi.response.saClassification.SaCategoryResponseBuilder;
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
public class SaCategoryReadController extends SaCategoryAbstractController {
    @Autowired
    private SaCategoryReadCmd cmd;

    @ApiOperation(value = "Read a sickness/accident Category")
    @RequestMapping(
            value = "/{saCategoryId}",
            method = RequestMethod.GET
    )
    public SingleRestResponse<SaCategoryResponse> readSaCategory(@PathVariable Integer saCategoryId,
                                                               @RequestParam(value = "userId", required = false) Integer userId) {
        cmd.setSaCategoryId(saCategoryId);
        cmd.execute();
        return new SingleRestResponse(SaCategoryResponseBuilder.getInstance(cmd.getSaCategory()).build());
    }
}
