package com.groupa.ssi.controller.personnel;

import com.groupa.ssi.common.response.rest.SingleRestResponse;
import com.groupa.ssi.response.personnel.DepartmentResponse;
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

    @ApiOperation(value = "Read/View Department")
    @RequestMapping(value = "/{departmentId}", method = RequestMethod.GET)
    public SingleRestResponse<DepartmentResponse> readWorkItem(@PathVariable Long departmentId, @RequestParam(value = "userId") Integer userId){
        return new SingleRestResponse<>(new DepartmentResponse());
    }
}
