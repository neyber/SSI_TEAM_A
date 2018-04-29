package com.groupa.ssi.controller.functionmanual;

import com.groupa.ssi.cmd.functionmanual.FunctionManualUpdateCmd;
import com.groupa.ssi.common.response.rest.SuccessRestResponse;
import com.groupa.ssi.request.functionmanual.FunctionManualRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

/**
 * @author Marcelo Loayza
 */
@Api(
        tags = FunctionManualAbstractController.TAG_NAME,
        description = FunctionManualAbstractController.DESCRIPTION
)
@RestController
@RequestScope
public class FunctionManualUpdateController extends FunctionManualAbstractController {

    @Autowired
    private FunctionManualUpdateCmd cmd;

    @ApiOperation(value = "Update function Manual item")
    @RequestMapping(
            value = "/{functionManualId}",
            method = RequestMethod.PUT
    )
    public SuccessRestResponse updateFunctionManual(@PathVariable Integer FunctionManualId,
                                              @RequestBody FunctionManualRequest functionManualRequest,
                                              @RequestParam(value = "userId", required = false) Integer userId) {

        cmd.setFunctionManualId(FunctionManualId);
        cmd.setWorkItemRequest(functionManualRequest);
        cmd.execute();

        return new SuccessRestResponse();
    }

}
