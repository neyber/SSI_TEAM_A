package com.groupa.ssi.controller.personnel;

import com.groupa.ssi.cmd.Personnel.DepartmentDeleteCmd;
import com.groupa.ssi.common.response.rest.SuccessRestResponse;
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
public class DepartmentDeleteController extends DepartmentAbstractController {

    @Autowired
    private DepartmentDeleteCmd departmentDeleteCmd;

    @ApiOperation(value = "Delete Department")
    @RequestMapping(value = "/{departmentId}", method = RequestMethod.DELETE)
    public SuccessRestResponse deleteDepartment(@PathVariable Integer departmentId,
                                                @RequestParam(value = "userId", required = false) Integer userId){
        departmentDeleteCmd.setDepartmentId(departmentId);
        departmentDeleteCmd.execute();
        return new SuccessRestResponse();
    }
}
