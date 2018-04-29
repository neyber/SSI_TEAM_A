package com.groupa.ssi.controller.personnel;

import com.groupa.ssi.cmd.Personnel.RoleReadCmd;
import com.groupa.ssi.common.response.rest.SingleRestResponse;
import com.groupa.ssi.response.personnel.RoleResponse;
import com.groupa.ssi.response.personnel.RoleResponseBuilder;
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
public class RoleReadController extends RoleAbstractController{

    @Autowired
    private RoleReadCmd roleReadCmd;

    @ApiOperation(value = "Read/View Role")
    @RequestMapping(value = "/{roleId}", method = RequestMethod.GET)
    public SingleRestResponse<RoleResponse> readRole(@PathVariable Integer roleId, @RequestParam(value = "userId", required = false) Integer userId){
        roleReadCmd.setRoleId(roleId);
        roleReadCmd.execute();
        return new SingleRestResponse<>(RoleResponseBuilder.getInstance(roleReadCmd.getRole()).build());
    }
}
