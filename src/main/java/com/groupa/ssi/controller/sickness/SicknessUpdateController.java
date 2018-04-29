/*
@author: HENRYBC
*/
package com.groupa.ssi.controller.sickness;

import com.groupa.ssi.cmd.sickness.SicknessUpdateCmd;
import com.groupa.ssi.common.response.rest.SuccessRestResponse;
import com.groupa.ssi.model.domain.sickness.Sickness;
import com.groupa.ssi.request.accident.AccidentRequest;
import com.groupa.ssi.request.sickness.SicknessRequest;
import com.groupa.ssi.services.sickness.SicknessService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

@Api(
        tags = SicknessAbstractController.TAG_NAME,
        description = SicknessAbstractController.DESCRIPTION
)
@RestController
@RequestScope
public class SicknessUpdateController extends SicknessAbstractController {

    @Autowired
    private SicknessUpdateCmd cmd;

    @ApiOperation(value = "Update an sickness")
    @RequestMapping(
            value = "/{sicknessId}",
            method = RequestMethod.PUT
    )
    public SuccessRestResponse updateSickness(@PathVariable Integer sicknessId,
                                              @RequestBody SicknessRequest sicknessRequest,
                                              @RequestParam(value = "userId") Integer userId){
        cmd.setSicknessId(sicknessId);
        cmd.setSicknessRequest(sicknessRequest);
        return new SuccessRestResponse();
    }
}
