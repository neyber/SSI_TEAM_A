/*
@author: HENRYBC
*/
package com.groupa.ssi.controller.sickness;

import com.groupa.ssi.cmd.sickness.SicknessCreateCmd;
import com.groupa.ssi.common.response.rest.SuccessRestResponse;
import com.groupa.ssi.request.sickness.SicknessRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

@Api(
        tags = SicknessAbstractController.TAG_NAME,
        description = SicknessAbstractController.DESCRIPTION
)
@RestController
@RequestScope
public class SicknessCreateController extends SicknessAbstractController {

    @Autowired
    private SicknessCreateCmd cmd;

    @ApiOperation(value = "create sickness ")
    @RequestMapping(
            method = RequestMethod.POST
    )
    public SuccessRestResponse createSicknessRecord(@RequestBody SicknessRequest sicknessRequest,
                                                    @RequestParam(value = "userId", required = false) Integer userId) {
        cmd.setSicknessRequest(sicknessRequest);
        cmd.execute();
        return new SuccessRestResponse();
    }
}
