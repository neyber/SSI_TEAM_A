package com.groupa.ssi.controller.personalprotectionequipment;

import com.groupa.ssi.cmd.personalprotectionequipment.ExistingPpeReadCmd;
import com.groupa.ssi.common.response.rest.SingleRestResponse;
import com.groupa.ssi.response.personalprotectionequipment.ExistingPpeResponse;
import com.groupa.ssi.response.personalprotectionequipment.ExistingPpeResponseBuilder;
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
public class ExistingPpeReadController extends ExistingPpeAbstractController {

    private ExistingPpeReadCmd cmd;

    public ExistingPpeReadController(ExistingPpeReadCmd cmd) {
        this.cmd = cmd;
    }

    @ApiOperation(value = "Read an existing personal protection equipment")
    @RequestMapping(
            value = "/{existingPpeId}",
            method = RequestMethod.GET
    )
    public SingleRestResponse<ExistingPpeResponse> readExistingPpe(@PathVariable Integer existingPpeId,
                                                           @RequestParam(value = "userId") Integer userId) {

        cmd.setExistingPpeId(existingPpeId);
        cmd.execute();

        return new SingleRestResponse<>(ExistingPpeResponseBuilder.getInstance(cmd.getExistingPpe()).build());
    }


}
