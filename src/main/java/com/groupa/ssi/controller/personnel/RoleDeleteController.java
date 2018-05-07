package com.groupa.ssi.controller.personnel;

import com.groupa.ssi.cmd.Personnel.RoleDeleteCmd;
import com.groupa.ssi.common.response.rest.SuccessRestResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

/**
 * @author Lizeth Salazar
 */

@Api(tags = RoleAbstractController.TAG_NAME, description = RoleAbstractController.DESCRIPTION)
@RestController
@RequestScope
public class RoleDeleteController extends RoleAbstractController{

    @Autowired
    private RoleDeleteCmd roleDeleteCmd;

    @ApiOperation(value = "Delete Role")
    @RequestMapping(value = "/{roleId}", method = RequestMethod.DELETE)
    public SuccessRestResponse deleteRole(@PathVariable Integer roleId, @RequestParam(value = "userId", required = false) Integer userId){
        roleDeleteCmd.setRoleId(roleId);
        roleDeleteCmd.execute();
        return new SuccessRestResponse();
    }
}
