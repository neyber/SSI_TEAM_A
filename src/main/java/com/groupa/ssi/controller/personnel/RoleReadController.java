package com.groupa.ssi.controller.personnel;

import com.groupa.ssi.common.response.rest.SingleRestResponse;
import com.groupa.ssi.response.personnel.RoleResponse;
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
public class RoleReadController extends RoleAbstractController{

    @ApiOperation(value = "Read/View Role")
    @RequestMapping(value = "/{roleId}", method = RequestMethod.GET)
    public SingleRestResponse<RoleResponse> readRole(@PathVariable Integer roleId, @RequestParam(value = "userId") Integer userId){
        return new SingleRestResponse<>(new RoleResponse());
    }
}
