package com.groupa.ssi.controller.personnel;

import com.groupa.ssi.cmd.Personnel.EmployeeListCmd;
import com.groupa.ssi.common.response.rest.ListRestResponse;
import com.groupa.ssi.response.personnel.EmployeeResponse;
import com.groupa.ssi.response.personnel.EmployeeResponseBuilder;
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

@Api(tags = EmployeeAbstractController.TAG_NAME, description = EmployeeAbstractController.DESCRIPTION)
@RestController
@RequestScope
public class EmployeeListController extends EmployeeAbstractController{

    @Autowired
    private EmployeeListCmd employeeListCmd;

    @ApiOperation(value = "List Employees")
    @RequestMapping(method = RequestMethod.GET)
    public ListRestResponse<EmployeeResponse> getEmployeesList(@RequestParam(value="userId", required = false) Integer userId){

        employeeListCmd.execute();
        List<EmployeeResponse> employeesList = employeeListCmd.getEmployeesList().stream()
                .map(instance -> EmployeeResponseBuilder.getInstance(instance).build())
                .collect(Collectors.toList());

        return new ListRestResponse<>(employeesList);
    }
}
