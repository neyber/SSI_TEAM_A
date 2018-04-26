/*
@author: HENRYBC
*/
package com.groupa.ssi.controller.sickness;

import com.groupa.ssi.common.response.rest.SuccessRestResponse;
import com.groupa.ssi.request.sickness.SicknessRequest;
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
public class SicknessDeleteController extends SicknessAbstractController {

    @ApiOperation(value = "delete sickness")
    @RequestMapping(
            value = "/{sicknessId}",
            method = RequestMethod.DELETE
    )
    public SuccessRestResponse deleteSickness(@RequestBody SicknessRequest sicknessRequest,
                                              @RequestParam(value = "userId") Integer userId) {
        return new SuccessRestResponse();
    }
}
