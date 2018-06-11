package com.groupa.ssi.cmd.Personnel;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.personnel.Employee;
import com.groupa.ssi.services.personnel.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Lizeth Salazar
 */

@CommandScoped
public class EmployeeListCmd extends AbstractCommand {

    @Autowired
    private EmployeeService employeeService;

    private List<Employee> employeesList;

    @Override
    protected void run() {
        employeesList = employeeService.procedureFindAll();
    }

    public List<Employee> getEmployeesList() {
        return employeesList;
    }
}
