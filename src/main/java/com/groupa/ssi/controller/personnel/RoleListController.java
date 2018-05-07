package com.groupa.ssi.controller.personnel;

import com.groupa.ssi.cmd.Personnel.RoleListCmd;
import com.groupa.ssi.common.response.rest.ListRestResponse;
import com.groupa.ssi.response.personnel.RoleResponse;
import com.groupa.ssi.response.personnel.RoleResponseBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Lizeth Salazar
 */

@Api(tags = RoleAbstractController.TAG_NAME, description = RoleAbstractController.DESCRIPTION)
@RestController
@RequestScope
public class RoleListController extends RoleAbstractController{

    @Autowired
    private RoleListCmd roleListCmd;

    @ApiOperation(value = "List Roles")
    @RequestMapping(method = RequestMethod.GET)
    public ListRestResponse<RoleResponse> getRolesList(@RequestParam(value="userId", required = false) Integer userId){

        roleListCmd.execute();
        List<RoleResponse> rolesList = roleListCmd.getRolesList().stream()
                .map(instance -> RoleResponseBuilder.getInstance(instance).build())
                .collect(Collectors.toList());
        return new ListRestResponse<>(rolesList);
    }

}
