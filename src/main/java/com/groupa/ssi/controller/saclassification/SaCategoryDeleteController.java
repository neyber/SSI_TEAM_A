package com.groupa.ssi.controller.saclassification;

/*
Created on 13/5/18
@author: HENRYBC
*/

import com.groupa.ssi.cmd.saclassification.SaCategoryDeleteCmd;
import com.groupa.ssi.common.response.rest.SuccessRestResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

@Api(
        tags = SaCategoryAbstractController.TAG_NAME,
        description = SaCategoryAbstractController.DESCRIPTION
)
@RestController
@RequestScope
public class SaCategoryDeleteController extends SaCategoryAbstractController {
    @Autowired
    private SaCategoryDeleteCmd cmd;

    @ApiOperation(value = "delete saCategory")
    @RequestMapping(
            value = "/{saCategoryId}",
            method = RequestMethod.DELETE
    )
    public SuccessRestResponse deleteSaCategory(@PathVariable Integer saCategoryId,
                                                @RequestParam(value = "userId", required = false) Integer userId) {

        cmd.setSaCategoryId(saCategoryId);
        cmd.execute();
        return new SuccessRestResponse();

    }
}
