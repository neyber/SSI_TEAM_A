package com.groupa.ssi.controller.personalprotectionequipment;

import com.groupa.ssi.cmd.personalprotectionequipment.ExistingPpeAssignedUpdateCmd;
import com.groupa.ssi.cmd.personalprotectionequipment.ExistingPpeUpdateCmd;
import com.groupa.ssi.common.response.rest.SuccessRestResponse;
import com.groupa.ssi.request.personalprotectionequipment.ExistingPpeAssignedRequest;
import com.groupa.ssi.request.personalprotectionequipment.ExistingPpeRequest;
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
public class ExistingPpeAssignedUpdateController extends ExistingPpeAssignedAbstractController {

    @Autowired
    private ExistingPpeAssignedUpdateCmd cmd;

    @ApiOperation(value = "Update existing personal protection equipment assigned")
    @RequestMapping(
            value = "/{existingPpeAssignedId}",
            method = RequestMethod.PUT
    )
    public SuccessRestResponse updateExistingPpeAssigned(@PathVariable Integer existingPpeAssignedId,
                                              @RequestBody ExistingPpeAssignedRequest existingPpeAssignedRequest,
                                              @RequestParam(value = "userId", required = false) Integer userId) {
        cmd.setExistingPpeAssignedId(existingPpeAssignedId);
        cmd.setExistingPpeAssignedRequest(existingPpeAssignedRequest);
        cmd.execute();

        return new SuccessRestResponse();
    }

}
