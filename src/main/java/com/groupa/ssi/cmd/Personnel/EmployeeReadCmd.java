package com.groupa.ssi.cmd.Personnel;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.personnel.Employee;
import com.groupa.ssi.services.personnel.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Lizeth Salazar
 */

@CommandScoped
public class EmployeeReadCmd extends AbstractCommand {

    @Autowired
    private EmployeeService employeeService;

    private Integer employeeId;
    private Employee employee;

    @Override
    protected void run() {
        employee = employeeService.findById(employeeId);
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }
}
