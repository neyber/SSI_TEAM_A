/*
@author: HENRYBC
*/
package com.groupa.ssi.controller.sickness;

import com.groupa.ssi.common.response.rest.SuccessRestResponse;
import com.groupa.ssi.request.accident.AccidentRequest;
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
public class SicknessUpdateController extends SicknessAbstractController {

    @ApiOperation(value = "Update an sickness")
    @RequestMapping(
            value = "/{sicknessId}",
            method = RequestMethod.PUT
    )
    public SuccessRestResponse updateSickness(@PathVariable Integer sicknessId,
                                              @RequestBody AccidentRequest accidentRequest,
                                              @RequestParam(value = "userId") Integer userId){
        return new SuccessRestResponse();
    }
}
