package com.groupa.ssi.cmd.Personnel;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.personnel.Department;
import com.groupa.ssi.services.personnel.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Lizeth Salazar
 */

@CommandScoped
public class DepartmentReadCmd extends AbstractCommand {

    @Autowired
    private DepartmentService departmentService;

    private Integer departmentId;
    private Department department;

    @Override
    protected void run() {
        department = departmentService.findById(departmentId);
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Department getDepartment() {
        return department;
    }
}
