package com.groupa.ssi.controller.usermanual;

import com.groupa.ssi.common.response.rest.SuccessRestResponse;
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
public class UserManualDeleteController extends UserManualAbstractController {

    @ApiOperation(value = "Delete UserManual")
    @RequestMapping(value = "/{userManualId}", method = RequestMethod.DELETE)
    public SuccessRestResponse deleteUserManua(@PathVariable Long userManualId,
                                                @RequestParam(value = "userId") Integer userId){
        return new SuccessRestResponse();
    }
}
