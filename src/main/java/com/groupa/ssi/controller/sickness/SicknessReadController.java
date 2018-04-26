/*
@author: HENRYBC
*/
package com.groupa.ssi.controller.sickness;

import com.groupa.ssi.common.response.rest.SingleRestResponse;
import com.groupa.ssi.response.sickness.SicknessResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

@Api(
        tags = SicknessAbstractController.TAG_NAME,
        description = SicknessAbstractController.DESCRIPTION
)
@RestController
@RequestScope
public class SicknessReadController extends SicknessAbstractController {

    @ApiOperation(value = "Read an sickness")
    @RequestMapping(
            value = "/{sicknessId}",
            method = RequestMethod.GET
    )
    public SingleRestResponse<SicknessResponse> readSickness(@PathVariable Integer sicknessId,
                                                             @RequestParam(value = "userId") Integer userId){
        return new SingleRestResponse<>(new SicknessResponse());
    }
}
