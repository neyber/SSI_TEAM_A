package com.groupa.ssi.controller.personalprotectionequipment;

import com.groupa.ssi.cmd.personalprotectionequipment.ExistingPpeAssignedReadCmd;
import com.groupa.ssi.common.response.rest.SingleRestResponse;
import com.groupa.ssi.response.personalprotectionequipment.ExistingPpeAssignedResponse;
import com.groupa.ssi.response.personalprotectionequipment.ExistingPpeAssignedResponseBuilder;
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
public class ExistingPpeAssignedReadController extends ExistingPpeAssignedAbstractController {

    @Autowired
    private ExistingPpeAssignedReadCmd cmd;

    @ApiOperation(value = "Read an existing personal protection equipment assigned")
    @RequestMapping(
            value = "/{existingPpeAssignedId}",
            method = RequestMethod.GET
    )
    public SingleRestResponse<ExistingPpeAssignedResponse> readExistingPpeAssigned(@PathVariable Integer existingPpeAssignedId,
                                                                                   @RequestParam(value = "userId", required = false) Integer userId) {

        cmd.setExistingPpeAssignedId(existingPpeAssignedId);
        cmd.execute();

        return new SingleRestResponse<>(ExistingPpeAssignedResponseBuilder.getInstance(cmd.getExistingPpeAssigned()).build());
    }


}
