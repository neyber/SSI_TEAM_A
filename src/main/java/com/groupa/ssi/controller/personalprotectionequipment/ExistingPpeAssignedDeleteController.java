package com.groupa.ssi.controller.personalprotectionequipment;

import com.groupa.ssi.cmd.personalprotectionequipment.ExistingPpeAssignedDeleteCmd;
import com.groupa.ssi.common.response.rest.SuccessRestResponse;
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
public class ExistingPpeAssignedDeleteController extends ExistingPpeAssignedAbstractController {

    @Autowired
    private ExistingPpeAssignedDeleteCmd cmd;

    @ApiOperation(value = "Delete existing personal protection equipment assigned")
    @RequestMapping(
            value = "/{existingPpeAssignedId}",
            method = RequestMethod.DELETE
    )
    public SuccessRestResponse deleteExistingPpeAssigned(@PathVariable Integer existingPpeAssignedId,
                                              @RequestParam(value = "userId", required = false) Integer userId) {
        cmd.setExistingPpeAssignedId(existingPpeAssignedId);
        cmd.execute();

        return new SuccessRestResponse();
    }

}
