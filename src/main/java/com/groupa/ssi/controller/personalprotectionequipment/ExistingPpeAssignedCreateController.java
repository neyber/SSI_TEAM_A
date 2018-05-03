package com.groupa.ssi.controller.personalprotectionequipment;

import com.groupa.ssi.cmd.personalprotectionequipment.ExistingPpeAssignedCreateCmd;
import com.groupa.ssi.common.response.rest.SuccessRestResponse;
import com.groupa.ssi.request.personalprotectionequipment.ExistingPpeAssignedRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

/**
 * Created on April 30, 2018
 * @author Walker Colina
 */
@Api(
        tags = ExistingPpeAssignedAbstractController.TAG_NAME,
        description = ExistingPpeAssignedAbstractController.DESCRIPTION
)
@RestController
@RequestScope
public class ExistingPpeAssignedCreateController extends ExistingPpeAssignedAbstractController {

    @Autowired
    private ExistingPpeAssignedCreateCmd cmd;

    @ApiOperation(value = "Create existing personal protection equipment assigned")
    @RequestMapping(
            method = RequestMethod.POST
    )
    public SuccessRestResponse createExistingPpeAssigned(@RequestBody ExistingPpeAssignedRequest existingPpeAssignedRequest,
                                              @RequestParam(value = "userId", required = false) Integer userId) {
        cmd.setExistingPpeAssignedRequest(existingPpeAssignedRequest);
        cmd.execute();

        return new SuccessRestResponse();
    }
}
