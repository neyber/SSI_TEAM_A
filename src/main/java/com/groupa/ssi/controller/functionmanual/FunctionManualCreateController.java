package com.groupa.ssi.controller.functionmanual;

import com.groupa.ssi.cmd.functionmanual.FunctionManualCreateCmd;
import com.groupa.ssi.common.response.rest.SuccessRestResponse;
import com.groupa.ssi.request.functionmanual.FunctionManualRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Marcelo Loayza
 */

@Api(tags = FunctionManualAbstractController.TAG_NAME, description = FunctionManualAbstractController.DESCRIPTION)
@RestController
@RequestMapping
public class FunctionManualCreateController extends FunctionManualAbstractController {

    @Autowired
    private FunctionManualCreateCmd cmd;

    @ApiOperation(value = "Create FunctionManual")
    @RequestMapping(
            method = RequestMethod.POST
    )
    public SuccessRestResponse createDepartment(@RequestBody FunctionManualRequest functionManualRequest,
                                                @RequestParam(value = "userId", required = false) Integer userId) {
        cmd.setFunctionManualRequest(functionManualRequest);
        cmd.execute();

        return new SuccessRestResponse();
    }
}
