package com.groupa.ssi.controller.personnel;

import com.groupa.ssi.cmd.Personnel.EmployeeDeleteCmd;
import com.groupa.ssi.common.response.rest.SuccessRestResponse;
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
public class EmployeeDeleteController extends EmployeeAbstractController {

    @Autowired
    private EmployeeDeleteCmd employeeDeleteCmd;
    
    @ApiOperation(value = "Delete Employee")
    @RequestMapping(value = "/{employeeId}", method = RequestMethod.DELETE)
    public SuccessRestResponse deleteEmployee(@PathVariable Integer employeeId, @RequestParam(value = "userId", required = false) Integer userId){
        employeeDeleteCmd.setEmployeeId(employeeId);
        employeeDeleteCmd.execute();
        return new SuccessRestResponse();
    }
}
