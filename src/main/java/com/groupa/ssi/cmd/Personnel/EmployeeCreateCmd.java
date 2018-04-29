package com.groupa.ssi.cmd.Personnel;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.personnel.Employee;
import com.groupa.ssi.request.personnel.EmployeeRequest;
import com.groupa.ssi.services.personnel.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Lizeth Salazar
 */

@CommandScoped
public class EmployeeCreateCmd extends AbstractCommand {
    private EmployeeRequest employeeRequest;

    @Autowired
    private EmployeeService employeeService;

    @Override
    protected void run() {
        Employee employee = ComposeEmployee(employeeRequest);
        employeeService.save(employee);
    }

    private Employee ComposeEmployee(EmployeeRequest employeeRequest) {
        Employee employee = new Employee();
        employee.setIdentificationNumber(employeeRequest.getIdentificationNumber());
        employee.setFirstName(employeeRequest.getFirstName());
        employee.setLastName(employeeRequest.getLastName());
        employee.setDateOfBirth(employeeRequest.getDateOfBirth());
        employee.setGender(employeeRequest.getGender());
        employee.setStartDateInCompany(employeeRequest.getStartDateInCompany());
        employee.setSupervisor(employeeRequest.getSupervisor());
        employee.setDepartmentEmployee(employeeRequest.getDepartmentEmployee());
        employee.setRoleEmployee(employeeRequest.getRoleEmployee());
        employee.setHealthConditionStartingAtCompany(employeeRequest.getHealthConditionStartingAtCompany());
        employee.setPhoto(employeeRequest.getPhoto());

        return employee;
    }

    public void setEmployeeRequest(EmployeeRequest employeeRequest) {
        this.employeeRequest = employeeRequest;
    }
}
