package com.groupa.ssi.cmd.Personnel;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.services.personnel.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Lizeth Salazar
 */

@CommandScoped
public class DepartmentDeleteCmd extends AbstractCommand {
    private Integer departmentId;

    @Autowired
    private DepartmentService departmentService;

    @Override
    protected void run() {
        departmentService.procedureDeleteById(departmentId);
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }
}
