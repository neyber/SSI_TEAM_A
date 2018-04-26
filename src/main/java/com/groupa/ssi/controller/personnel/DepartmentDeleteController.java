package com.groupa.ssi.controller.personnel;

import com.groupa.ssi.common.response.rest.SuccessRestResponse;
import com.groupa.ssi.services.personnel.DepartmentService;
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
public class DepartmentDeleteController extends DepartmentAbstractController {
    private DepartmentService service;

    public DepartmentDeleteController(DepartmentService service) {
        this.service = service;
    }

    @ApiOperation(value = "Delete Department")
    @RequestMapping(value = "/{departmentId}", method = RequestMethod.DELETE)
    public SuccessRestResponse deleteDepartment(@PathVariable Integer departmentId,
                                                @RequestParam(value = "userId") Integer userId){
        service.deleteById(departmentId);
        // TO DO ---- to UPDATE once we have Commands working
        return new SuccessRestResponse();
    }
}
