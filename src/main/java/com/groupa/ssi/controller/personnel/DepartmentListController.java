package com.groupa.ssi.controller.personnel;

import com.groupa.ssi.cmd.Personnel.DepartmentListCmd;
import com.groupa.ssi.common.response.rest.ListRestResponse;
import com.groupa.ssi.model.domain.personnel.Department;
import com.groupa.ssi.response.personnel.DepartmentResponse;
import com.groupa.ssi.response.personnel.DepartmentResponseBuilder;
import com.groupa.ssi.services.personnel.DepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Lizeth Salazar
 */

@Api(tags = DepartmentAbstractController.TAG_NAME, description = DepartmentAbstractController.DESCRIPTION)
@RestController
@RequestScope
public class DepartmentListController extends DepartmentAbstractController{

    @Autowired
    private DepartmentListCmd departmentListCmd;

    @ApiOperation(value = "List Departments")
    @RequestMapping(method = RequestMethod.GET)
    public ListRestResponse<DepartmentResponse> getDepartmentList(@RequestParam(value="userId", required = false) Integer userId){

        departmentListCmd.execute();
        List<DepartmentResponse> departmentsList = departmentListCmd.getDepartmentsList().stream()
                .map(instance -> DepartmentResponseBuilder.getInstance(instance).build())
                .collect(Collectors.toList());

        return new ListRestResponse<>(departmentsList);
    }
}