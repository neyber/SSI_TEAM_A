package com.groupa.ssi.controller.personalprotectionequipment;

import com.groupa.ssi.cmd.personalprotectionequipment.ExistingPpeDeleteCmd;
import com.groupa.ssi.common.response.rest.SuccessRestResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
public class ExistingPpeDeleteController extends ExistingPpeAbstractController {

    private ExistingPpeDeleteCmd cmd;

    public ExistingPpeDeleteController(ExistingPpeDeleteCmd cmd) {
        this.cmd = cmd;
    }

    @ApiOperation(value = "Delete existing personal protection equipment")
    @RequestMapping(
            value = "/{existingPpeId}",
            method = RequestMethod.DELETE
    )
    public SuccessRestResponse deleteExistingPpe(@PathVariable Integer existingPpeId,
                                              @RequestParam(value = "userId") Integer userId) {
        cmd.setExistingPpeId(existingPpeId);
        cmd.execute();
        return new SuccessRestResponse();
    }

}
