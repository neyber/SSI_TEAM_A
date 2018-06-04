package com.groupa.ssi.cmd.Personnel;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.personnel.Department;
import com.groupa.ssi.request.personnel.DepartmentRequest;
import com.groupa.ssi.services.personnel.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Lizeth Salazar
 */

@CommandScoped
public class DepartmentUpdateCmd extends AbstractCommand {

    @Autowired
    private DepartmentService departmentService;

    private Integer departmentId;
    private DepartmentRequest departmentRequest;

    @Override
    protected void run() {
        Department department = composeDepartment(departmentId, departmentRequest);
        departmentService.procedureUpdate(department);
    }

    private Department composeDepartment(Integer departmentId, DepartmentRequest departmentRequest) {
        Department department = departmentService.findById(departmentId);
        department.setName(departmentRequest.getName());
        department.setDescription(departmentRequest.getDescription());

        return department;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public void setDepartmentRequest(DepartmentRequest departmentRequest) {
        this.departmentRequest = departmentRequest;
    }
}
