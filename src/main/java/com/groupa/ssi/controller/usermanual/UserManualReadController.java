package com.groupa.ssi.controller.usermanual;

import com.groupa.ssi.common.response.rest.SingleRestResponse;
import com.groupa.ssi.response.usermanual.UserManualResponse;
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
public class UserManualReadController extends UserManualAbstractController {

    @ApiOperation(value = "Read/View UserManual")
    @RequestMapping(value = "/{userManualId}", method = RequestMethod.GET)
    public SingleRestResponse<UserManualResponse> readUseManual(@PathVariable Long userManualId, @RequestParam(value = "userId") Integer userId){
        return new SingleRestResponse<>(new UserManualResponse());
    }
}
