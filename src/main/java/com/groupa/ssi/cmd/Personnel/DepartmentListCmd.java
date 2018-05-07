package com.groupa.ssi.cmd.Personnel;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.personnel.Department;
import com.groupa.ssi.services.personnel.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Lizeth Salazar
 */

@CommandScoped
public class DepartmentListCmd extends AbstractCommand {

    @Autowired
    private DepartmentService departmentService;

    private List<Department> departmentsList;

    @Override
    protected void run() {
        departmentsList = departmentService.findAll();
    }

    public List<Department> getDepartmentsList() {
        return departmentsList;
    }
}
