package com.groupa.ssi.controller.personnel;

import com.groupa.ssi.cmd.Personnel.DepartmentReadCmd;
import com.groupa.ssi.common.response.rest.SingleRestResponse;
import com.groupa.ssi.response.personnel.DepartmentResponse;
import com.groupa.ssi.response.personnel.DepartmentResponseBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

/**
 * @author Lizeth Salazar
 */

@Api(tags = DepartmentAbstractController.TAG_NAME, description = DepartmentAbstractController.DESCRIPTION)
@RestController
@RequestScope
public class DepartmentReadController extends DepartmentAbstractController{

    @Autowired
    private DepartmentReadCmd departmentReadCmd;

    @ApiOperation(value = "Read/View Department")
    @RequestMapping(value = "/{departmentId}", method = RequestMethod.GET)
    public SingleRestResponse<DepartmentResponse> readDepartment(@PathVariable Integer departmentId, @RequestParam(value = "userId", required = false) Integer userId){

        departmentReadCmd.setDepartmentId(departmentId);
        departmentReadCmd.execute();
        return new SingleRestResponse<>(DepartmentResponseBuilder.getInstance(departmentReadCmd.getDepartment()).build());
    }
}
