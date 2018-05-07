package com.groupa.ssi.controller.personalprotectionequipment;

import com.groupa.ssi.cmd.personalprotectionequipment.ExistingPpeUpdateCmd;
import com.groupa.ssi.common.response.rest.SuccessRestResponse;
import com.groupa.ssi.model.domain.personalprotectionequipment.Ppe;
import com.groupa.ssi.request.personalprotectionequipment.ExistingPpeRequest;
import com.groupa.ssi.request.personalprotectionequipment.PpeRequest;
import com.groupa.ssi.services.personalprotectionequipment.PpeService;
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
public class ExistingPpeUpdateController extends ExistingPpeAbstractController {

    @Autowired
    private ExistingPpeUpdateCmd cmd;

    @ApiOperation(value = "Update existing personal protection equipment")
    @RequestMapping(
            value = "/{existingPpeId}",
            method = RequestMethod.PUT
    )
    public SuccessRestResponse updateExistingPpe(@PathVariable Integer existingPpeId,
                                              @RequestBody ExistingPpeRequest existingPpeRequest,
                                              @RequestParam(value = "userId", required = false) Integer userId) {
        cmd.setExistingPpeId(existingPpeId);
        cmd.setExistingPpeRequest(existingPpeRequest);
        cmd.execute();

        return new SuccessRestResponse();
    }

}
