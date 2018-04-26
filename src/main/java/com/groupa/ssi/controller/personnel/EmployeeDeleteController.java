package com.groupa.ssi.controller.personnel;

import com.groupa.ssi.common.response.rest.SuccessRestResponse;
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
public class EmployeeDeleteController extends EmployeeAbstractController {
    
    @ApiOperation(value = "Delete Employee")
    @RequestMapping(value = "/{employeeId}", method = RequestMethod.DELETE)
    public SuccessRestResponse deleteEmployee(@PathVariable Integer employeeId, @RequestParam(value = "userId") Integer userId){
        return new SuccessRestResponse();
    }
}
