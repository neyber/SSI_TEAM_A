package com.groupa.ssi.controller.personnel;

import com.groupa.ssi.common.response.rest.ListRestResponse;
import com.groupa.ssi.response.personnel.DepartmentResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;
import java.util.ArrayList;

/**
 * @author Lizeth Salazar
 */

@Api(tags = DepartmentAbstractController.TAG_NAME, description = DepartmentAbstractController.DESCRIPTION)
@RestController
@RequestScope
public class DepartmentListController extends DepartmentAbstractController{

    @ApiOperation(value = "List Departments")
    @RequestMapping(method = RequestMethod.GET)
    public ListRestResponse<DepartmentResponse> getDepartmentList(@RequestParam(value="userId") Integer userId){
        return new ListRestResponse<>(new ArrayList<>());
    }
}