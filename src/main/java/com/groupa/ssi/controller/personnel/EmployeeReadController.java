package com.groupa.ssi.controller.personnel;

import com.groupa.ssi.common.response.rest.SingleRestResponse;
import com.groupa.ssi.response.personnel.EmployeeResponse;
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
public class EmployeeReadController extends EmployeeAbstractController {

    @ApiOperation(value = "Read/View Employee")
    @RequestMapping(value = "/{employeeId}", method = RequestMethod.GET)
    public SingleRestResponse<EmployeeResponse> readEmployee(@PathVariable Integer employeeId, @RequestParam(value = "userId") Integer userId){
        return new SingleRestResponse<>(new EmployeeResponse());
    }
}
