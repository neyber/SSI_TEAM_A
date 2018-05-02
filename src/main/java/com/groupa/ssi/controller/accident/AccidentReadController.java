/*
@author: HENRYBC
*/
package com.groupa.ssi.controller.accident;

import com.groupa.ssi.cmd.accident.AccidentReadCmd;
import com.groupa.ssi.common.response.rest.SingleRestResponse;
import com.groupa.ssi.response.accident.AccidentResponse;
import com.groupa.ssi.response.accident.AccidentResponseBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

@Api(
        tags = AccidentAbstractController.TAG_NAME,
        description = AccidentAbstractController.DESCRIPTION
)
@RestController
@RequestScope
public class AccidentReadController extends AccidentAbstractController{

    @Autowired
    private AccidentReadCmd cmd;

    @ApiOperation(value = "Read an accident")
    @RequestMapping(
            value = "/{accidentId}",
            method = RequestMethod.GET
    )
    public SingleRestResponse<AccidentResponse> readAccident(@PathVariable Integer accidentId,
                                                        @RequestParam(value = "userId", required = false) Integer userId){
        cmd.setAccidentId(accidentId);
        cmd.execute();
        return new SingleRestResponse(AccidentResponseBuilder.getInstance(cmd.getAccident()).build());
    }
}
