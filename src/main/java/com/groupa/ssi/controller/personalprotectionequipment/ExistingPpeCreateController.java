package com.groupa.ssi.controller.personalprotectionequipment;

import com.groupa.ssi.cmd.personalprotectionequipment.ExistingPpeCreateCmd;
import com.groupa.ssi.common.response.rest.SuccessRestResponse;
import com.groupa.ssi.request.personalprotectionequipment.ExistingPpeRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

/**
 * Created on April 26, 2018
 * @author Walker Colina
 */
@Api(
        tags = ExistingPpeAbstractController.TAG_NAME,
        description = ExistingPpeAbstractController.DESCRIPTION
)
@RestController
@RequestScope
public class ExistingPpeCreateController extends ExistingPpeAbstractController {

    @Autowired
    private ExistingPpeCreateCmd cmd;

    @ApiOperation(value = "Create existing personal protection equipment")
    @RequestMapping(
            method = RequestMethod.POST
    )
    public SuccessRestResponse createExistingPpe(@RequestBody ExistingPpeRequest existingppeRequest,
                                              @RequestParam(value = "userId", required = false) Integer userId) {
        cmd.setExistingPpeRequest(existingppeRequest);
        cmd.execute();

        return new SuccessRestResponse();
    }
}
