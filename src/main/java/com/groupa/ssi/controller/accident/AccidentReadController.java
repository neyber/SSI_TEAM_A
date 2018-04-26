/*
@author: HENRYBC
*/
package com.groupa.ssi.controller.accident;

import com.groupa.ssi.common.response.rest.SingleRestResponse;
import com.groupa.ssi.response.accident.AccidentResponse;
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
public class AccidentReadController extends AccidentAbstractController{

    @ApiOperation(value = "Read an accident")
    @RequestMapping(
            value = "/{accidentId}",
            method = RequestMethod.GET
    )
    public SingleRestResponse<AccidentResponse> readAccident(@PathVariable Integer accidentId,
                                                             @RequestParam(value = "userId") Integer userId){
        System.out.println(" Implementation pending... readAccidentItem" );
        return new SingleRestResponse<>(new AccidentResponse());

    }
}
