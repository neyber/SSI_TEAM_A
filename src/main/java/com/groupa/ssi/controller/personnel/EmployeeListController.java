package com.groupa.ssi.controller.personnel;

import com.groupa.ssi.common.response.rest.ListRestResponse;
import com.groupa.ssi.response.personnel.EmployeeResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import java.util.ArrayList;

/**
 * @author Lizeth Salazar
 */

@Api(tags = EmployeeAbstractController.TAG_NAME, description = EmployeeAbstractController.DESCRIPTION)
@RestController
@RequestScope
public class EmployeeListController extends EmployeeAbstractController{

    @ApiOperation(value = "List Employees")
    @RequestMapping(method = RequestMethod.GET)
    public ListRestResponse<EmployeeResponse> getEmployeesList(@RequestParam(value="userId") Integer userId){
        return new ListRestResponse<>(new ArrayList<>());
    }
}
