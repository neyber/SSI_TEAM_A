package com.groupa.ssi.controller.personnel;

import com.groupa.ssi.common.response.rest.SingleRestResponse;
import com.groupa.ssi.model.domain.personnel.Department;
import com.groupa.ssi.response.personnel.DepartmentResponse;
import com.groupa.ssi.response.personnel.DepartmentResponseBuilder;
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
public class DepartmentReadController extends DepartmentAbstractController{
    private DepartmentService service;

    public DepartmentReadController(DepartmentService service) {
        this.service = service;
    }

    @ApiOperation(value = "Read/View Department")
    @RequestMapping(value = "/{departmentId}", method = RequestMethod.GET)
    public SingleRestResponse<DepartmentResponse> readDepartment(@PathVariable Integer departmentId, @RequestParam(value = "userId") Integer userId){
        Department department = service.findById(departmentId);
        // TO DO ---- to UPDATE once we have Commands working
        return new SingleRestResponse<>(DepartmentResponseBuilder.getInstance(department).build());
    }
}
