package com.groupa.ssi.controller.personalprotectionequipment;

import com.groupa.ssi.cmd.personalprotectionequipment.PpeReadCmd;
import com.groupa.ssi.common.response.rest.SingleRestResponse;
import com.groupa.ssi.response.personalprotectionequipment.PpeResponse;
import com.groupa.ssi.response.personalprotectionequipment.PpeResponseBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

/**
 * Created on April 25, 2018
 * @author Walker Colina
 */
@Api(
        tags = PpeAbstractController.TAG_NAME,
        description = PpeAbstractController.DESCRIPTION
)
@RestController
@RequestScope
public class PpeReadController extends PpeAbstractController {

    @Autowired
    private PpeReadCmd cmd;

    @ApiOperation(value = "Read a personal protection equipment")
    @RequestMapping(
            value = "/{ppeId}",
            method = RequestMethod.GET
    )
    public SingleRestResponse<PpeResponse> readPpe(@PathVariable Integer ppeId,
                                                                 @RequestParam(value = "userId", required = false) Integer userId) {

        cmd.setPpeId(ppeId);
        cmd.execute();

        return new SingleRestResponse<>(PpeResponseBuilder.getInstance(cmd.getPpe()).build());
    }


}
