/*
@author: HENRYBC
*/
package com.groupa.ssi.controller.sickness;

import com.groupa.ssi.cmd.sickness.SicknessDeleteCmd;
import com.groupa.ssi.common.response.rest.SuccessRestResponse;
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
public class SicknessDeleteController extends SicknessAbstractController {

    @Autowired
    private SicknessDeleteCmd cmd;

    @ApiOperation(value = "delete sickness")
    @RequestMapping(
            value = "/{sicknessId}",
            method = RequestMethod.DELETE
    )
    public SuccessRestResponse deleteSickness(@PathVariable Integer sicknessId,
                                              @RequestParam(value = "userId") Integer userId) {
        cmd.setSicknessId(sicknessId);
        cmd.execute();
        return new SuccessRestResponse();
    }
}
