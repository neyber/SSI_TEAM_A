/*
@author: HENRYBC
*/
package com.groupa.ssi.controller.accident;

import com.groupa.ssi.common.response.rest.SuccessRestResponse;
import com.groupa.ssi.request.accident.AccidentRequest;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

@Api(
        tags = AccidentAbstractController.TAG_NAME,
        description = AccidentAbstractController.DESCRIPTION
)
@RestController
@RequestScope
public class AccidentCreateController extends AccidentAbstractController {

    @RequestMapping(
            method = RequestMethod.POST
    )
    public SuccessRestResponse createAccidentRecord(@RequestBody AccidentRequest accidentRequest,
                                                    @RequestParam(value = "userId") Integer userId) {
        System.out.println(" Implementation pending... create accident");
        return new SuccessRestResponse();
    }
}
