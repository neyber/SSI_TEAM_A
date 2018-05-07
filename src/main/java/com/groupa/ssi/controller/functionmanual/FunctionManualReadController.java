package com.groupa.ssi.controller.functionmanual;

import com.groupa.ssi.cmd.functionmanual.FunctionManualReadCmd;
import com.groupa.ssi.common.response.rest.SingleRestResponse;
import com.groupa.ssi.response.functionmanual.FunctionManualResponse;
import com.groupa.ssi.response.functionmanual.FunctionManualResponseBuilder;
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
public class FunctionManualReadController extends FunctionManualAbstractController {

    @Autowired
    private FunctionManualReadCmd cmd;

    @ApiOperation(value = "Read/View FunctionManual")
    @RequestMapping(value = "/{functionManualId}", method = RequestMethod.GET)
    public SingleRestResponse<FunctionManualResponse> readManual(@PathVariable Integer functionManualId, @RequestParam(value = "userId", required = false) Integer userId){

        cmd.setFunctionManualId(functionManualId);
        cmd.execute();
        return new SingleRestResponse<>(FunctionManualResponseBuilder.getInstance(cmd.getFunctionManual()).build());
    }
}
