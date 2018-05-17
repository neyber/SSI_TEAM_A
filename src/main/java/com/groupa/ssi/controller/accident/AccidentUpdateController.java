/*
@author: HENRYBC
*/
package com.groupa.ssi.controller.accident;

import com.groupa.ssi.cmd.accident.AccidentUpdateCmd;
import com.groupa.ssi.common.response.rest.SuccessRestResponse;
import com.groupa.ssi.model.domain.accident.Accident;
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
public class AccidentUpdateController extends AccidentAbstractController{

    @Autowired
    private AccidentUpdateCmd cmd;

    @ApiOperation(value = "Update accident")
    @RequestMapping(
            value = "/{accidentId}",
            method = RequestMethod.PUT
    )
    public SuccessRestResponse updateAccident(@PathVariable Integer accidentId,
                                             @RequestBody AccidentRequest accidentRequest,
                                             @RequestParam(value = "userId", required = false) Integer userId){
        cmd.setAccidentId(accidentId);
        cmd.setAccidentRequest(accidentRequest);
        cmd.execute();
        return new SuccessRestResponse();
    }
}
