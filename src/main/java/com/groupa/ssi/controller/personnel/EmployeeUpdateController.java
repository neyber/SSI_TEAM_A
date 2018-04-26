package com.groupa.ssi.controller.personnel;

import com.groupa.ssi.common.response.rest.SuccessRestResponse;
import com.groupa.ssi.request.personnel.EmployeeRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

/**
 * @author Lizeth Salazar
 */

@Api(tags = EmployeeAbstractController.TAG_NAME, description = EmployeeAbstractController.DESCRIPTION)
@RestController
@RequestScope
public class EmployeeUpdateController extends EmployeeAbstractController {

    @ApiOperation(value = "Update Employee")
    @RequestMapping(value = "/{employeeId}", method = RequestMethod.PUT)
    public SuccessRestResponse updateEmployee(@PathVariable Integer employeeId,
                                          @RequestBody EmployeeRequest employeeRequest,
                                          @RequestParam(value = "userId") Integer userId){
        return new SuccessRestResponse();
    }
}
