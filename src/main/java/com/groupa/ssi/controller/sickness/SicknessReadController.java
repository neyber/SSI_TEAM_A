/*
@author: HENRYBC
*/
package com.groupa.ssi.controller.sickness;

import com.groupa.ssi.cmd.sickness.SicknessReadCmd;
import com.groupa.ssi.common.response.rest.SingleRestResponse;
import com.groupa.ssi.response.sickness.SicknessResponse;
import com.groupa.ssi.response.sickness.SicknessResponseBuilder;
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
public class SicknessReadController extends SicknessAbstractController {

    @Autowired
    private SicknessReadCmd cmd;

    @ApiOperation(value = "Read an sickness")
    @RequestMapping(
            value = "/{sicknessId}",
            method = RequestMethod.GET
    )
    public SingleRestResponse<SicknessResponse> readSickness(@PathVariable Integer sicknessId,
                                                             @RequestParam(value = "userId", required = false) Integer userId){
        cmd.setSicknessId(sicknessId);
        cmd.execute();
        return new SingleRestResponse(SicknessResponseBuilder.getInstance(cmd.getSickness()).build());
    }
}
