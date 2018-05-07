/*
@author: HENRYBC
*/
package com.groupa.ssi.controller.accident;

import com.groupa.ssi.cmd.accident.AccidentCreateCmd;
import com.groupa.ssi.common.response.rest.SuccessRestResponse;
import com.groupa.ssi.request.accident.AccidentRequest;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

@Api(
        tags = AccidentAbstractController.TAG_NAME,
        description = AccidentAbstractController.DESCRIPTION
)
@RestController
@RequestScope
public class AccidentCreateController extends AccidentAbstractController {

    @Autowired
    private AccidentCreateCmd cmd;

    @RequestMapping(
            method = RequestMethod.POST
    )
    public SuccessRestResponse createAccidentRecord(@RequestBody AccidentRequest accidentRequest,
                                                    @RequestParam(value = "userId", required = false) Integer userId) {
        cmd.setAccidentRequest(accidentRequest);
        cmd.execute();
        return new SuccessRestResponse();
    }
}
