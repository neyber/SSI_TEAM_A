package com.groupa.ssi.controller.personnel;

import com.groupa.ssi.cmd.Personnel.EmployeeCreateCmd;
import com.groupa.ssi.common.response.rest.SuccessRestResponse;
import com.groupa.ssi.request.personnel.EmployeeRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

/**
 * @author Lizeth Salazar
 */

@Api(tags = EmployeeAbstractController.TAG_NAME, description = EmployeeAbstractController.DESCRIPTION)
@RestController
@RequestScope
public class EmployeeCreateController extends EmployeeAbstractController {

    @Autowired
    private EmployeeCreateCmd employeeCreateCmd;

    @ApiOperation(value = "Create Employee")
    @RequestMapping(
            method = RequestMethod.POST
    )
    public SuccessRestResponse createEmployee(@RequestBody EmployeeRequest employeeRequest, @RequestParam(value = "userId", required = false) Integer userId) {

        employeeCreateCmd.setEmployeeRequest(employeeRequest);
        employeeCreateCmd.execute();
        return new SuccessRestResponse();
    }
}
