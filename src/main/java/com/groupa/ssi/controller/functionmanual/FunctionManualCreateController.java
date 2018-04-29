package com.groupa.ssi.controller.usermanual;

import com.groupa.ssi.common.response.rest.SuccessRestResponse;
import com.groupa.ssi.request.usermanual.UserManualRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @author Marcelo Loayza
 */

@Api(tags = UserManualAbstractController.TAG_NAME, description = UserManualAbstractController.DESCRIPTION)
@RestController
@RequestMapping
public class UserManualCreateController extends UserManualAbstractController{

    @ApiOperation(value = "Create UserManual")
    @RequestMapping(
            method = RequestMethod.POST
    )
    public SuccessRestResponse createDepartment(@RequestBody UserManualRequest userManualRequest,
                                                @RequestParam(value = "userId") Integer userId) {
        return new SuccessRestResponse();
    }
}
