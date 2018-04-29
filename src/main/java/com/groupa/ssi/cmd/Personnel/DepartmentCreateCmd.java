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
public class DepartmentCreateCmd extends AbstractCommand {

    private DepartmentRequest departmentRequest;

    @Autowired
    private DepartmentService departmentService;

    @Override
    protected void run() {
        Department department = composeDepartment(departmentRequest);
        departmentService.save(department);
    }

    private Department composeDepartment(DepartmentRequest departmentRequest) {
        Department department = new Department();
        department.setName(departmentRequest.getName());
        department.setDescription(departmentRequest.getDescription());

        return department;
    }

    public void setDepartmentRequest(DepartmentRequest departmentRequest) {
        this.departmentRequest = departmentRequest;
    }
}
