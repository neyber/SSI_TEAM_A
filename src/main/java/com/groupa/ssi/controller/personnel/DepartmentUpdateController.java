package com.groupa.ssi.controller.personnel;

import com.groupa.ssi.common.response.rest.SuccessRestResponse;
import com.groupa.ssi.request.personnel.DepartmentRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

/**
 * @author Lizeth Salazar
 */

@Api(tags = DepartmentAbstractController.TAG_NAME, description = DepartmentAbstractController.DESCRIPTION)
@RestController
@RequestScope
public class DepartmentUpdateController extends DepartmentAbstractController{

    @ApiOperation(value = "Update Department")
    @RequestMapping(value = "/{departmentId}", method = RequestMethod.PUT)
    public SuccessRestResponse updateDeparment(@PathVariable Integer departmentId,
                                               @RequestBody DepartmentRequest departmentRequest,
                                               @RequestParam(value = "userId") Integer userId){
        return new SuccessRestResponse();
    }
}
