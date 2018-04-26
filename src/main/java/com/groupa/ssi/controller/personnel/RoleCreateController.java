package com.groupa.ssi.controller.personnel;

import com.groupa.ssi.common.response.rest.SuccessRestResponse;
import com.groupa.ssi.request.personnel.RoleRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

/**
 * @author Lizeth Salazar
 */

@Api(tags = RoleAbstractController.TAG_NAME, description = RoleAbstractController.DESCRIPTION)
@RestController
@RequestScope
public class RoleCreateController extends RoleAbstractController{

    @ApiOperation(value = "Create Role")
    @RequestMapping(
            method = RequestMethod.POST
    )
    public SuccessRestResponse createRole(@RequestBody RoleRequest roleRequest, @RequestParam(value = "userId") Integer userId) {
        return new SuccessRestResponse();
    }
}
