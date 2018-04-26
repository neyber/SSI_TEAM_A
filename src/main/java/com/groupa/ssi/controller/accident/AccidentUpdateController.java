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
public class AccidentUpdateController extends AccidentAbstractController{

    @ApiOperation(value = "Update accident")
    @RequestMapping(
            value = "/{accidentId}",
            method = RequestMethod.PUT
    )
    public SuccessRestResponse updateAccident(@PathVariable Integer workItemId,
                                             @RequestBody AccidentRequest accidentRequest,
                                             @RequestParam(value = "userId") Integer userId){
        System.out.println(" Implementation pending... updateAccident" );
        return new SuccessRestResponse();
    }
}
