package com.groupa.ssi.controller.usermanual;

import com.groupa.ssi.common.response.rest.SuccessRestResponse;
import com.groupa.ssi.request.usermanual.UserManualRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

/**
 * @author Marcelo Loayza
 */

@Api(tags = UserManualAbstractController.TAG_NAME, description = UserManualAbstractController.DESCRIPTION)
@RestController
@RequestScope
public class UserManualUpdateController extends UserManualAbstractController {

    @ApiOperation(value = "Update UserManuals")
    @RequestMapping(value = "/{userManualId}", method = RequestMethod.PUT)
    public SuccessRestResponse updateUserManual(@PathVariable Long userManualId,
                                               @RequestBody UserManualRequest userManualRequest,
                                               @RequestParam(value = "userId") Integer userId){
        return new SuccessRestResponse();
    }
}
