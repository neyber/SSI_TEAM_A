package com.groupa.ssi.controller.functionmanual;

import com.groupa.ssi.cmd.functionmanual.FunctionManualDeleteCmd;
import com.groupa.ssi.common.response.rest.SuccessRestResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

/**
 * @author Marcelo Loayza
 */

@Api(tags = FunctionManualAbstractController.TAG_NAME, description = FunctionManualAbstractController.DESCRIPTION)
@RestController
@RequestScope
public class FunctionManualDeleteController extends FunctionManualAbstractController {

    @Autowired
    private FunctionManualDeleteCmd cmd;

    @ApiOperation(value = "Delete FunctionManual")
    @RequestMapping(value = "/{functionManualId}", method = RequestMethod.DELETE)
    public SuccessRestResponse deleteManual(@PathVariable Integer functionManualId,
                                                @RequestParam(value = "userId", required = false) Integer userId){
        cmd.setFunctionManulIdId(functionManualId);
        cmd.execute();
        return new SuccessRestResponse();
    }
}
