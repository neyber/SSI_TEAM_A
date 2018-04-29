/*
@author: HENRYBC
*/
package com.groupa.ssi.controller.accident;

import com.groupa.ssi.cmd.accident.AccidentDeleteCmd;
import com.groupa.ssi.common.response.rest.SuccessRestResponse;
import com.groupa.ssi.request.accident.AccidentRequest;
import com.groupa.ssi.services.accident.AccidentService;
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
public class AccidentDeleteController extends AccidentAbstractController {

    @Autowired
    private AccidentDeleteCmd cmd;

    @ApiOperation(value = "delete accident")
    @RequestMapping(
            value = "/{accidentId}",
            method = RequestMethod.DELETE
    )
    public SuccessRestResponse deleteAccident(@PathVariable Integer accidentId,
                                              @RequestParam(value = "userId") Integer userId) {

        cmd.setAccidentId(accidentId);
        cmd.execute();
        return new SuccessRestResponse();

    }
}
