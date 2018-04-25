package com.groupa.ssi.controller.personnel;

import com.groupa.ssi.common.response.rest.SuccessRestResponse;
import com.groupa.ssi.request.personnel.DepartmentRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @author Lizeth Salazar
 */

@Api(tags = DepartmentAbstractController.TAG_NAME, description = DepartmentAbstractController.DESCRIPTION)
@RestController
@RequestMapping
public class DepartmentCreateController extends DepartmentAbstractController{

    @ApiOperation(value = "Create Department")
    @RequestMapping(
            method = RequestMethod.POST
    )
    public SuccessRestResponse createDepartment(@RequestBody DepartmentRequest departmentRequest,
                                              @RequestParam(value = "userId") Integer userId) {
        return new SuccessRestResponse();
    }
}
