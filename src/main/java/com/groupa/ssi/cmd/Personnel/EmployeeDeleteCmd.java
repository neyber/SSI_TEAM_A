package com.groupa.ssi.cmd.Personnel;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.services.personnel.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Lizeth Salazar
 */

@CommandScoped
public class EmployeeDeleteCmd extends AbstractCommand {
    private Integer employeeId;

    @Autowired
    private EmployeeService employeeService;

    @Override
    protected void run() {
        employeeService.deleteById(employeeId);
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }
}
