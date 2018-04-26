/*
@author: HENRYBC
*/
package com.groupa.ssi.controller.accident;

import com.groupa.ssi.common.response.rest.SuccessRestResponse;
import com.groupa.ssi.request.accident.AccidentRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

@Api(
        tags = AccidentAbstractController.TAG_NAME,
        description = AccidentAbstractController.DESCRIPTION
)
@RestController
@RequestScope
public class AccidentDeleteController extends AccidentAbstractController {

    @ApiOperation(value = "delete accident")
    @RequestMapping(
            value = "/{accidentId}",
            method = RequestMethod.DELETE
    )
    public SuccessRestResponse deleteAccident(@RequestBody AccidentRequest accidentRequest,
                                              @RequestParam(value = "userId") Integer userId) {

        return new SuccessRestResponse();

    }
}
