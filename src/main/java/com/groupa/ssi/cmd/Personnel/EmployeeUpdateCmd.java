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
public class EmployeeUpdateCmd extends AbstractCommand {

    @Autowired
    private EmployeeService employeeService;

    private Integer employeeId;
    private EmployeeRequest employeeRequest;

    @Override
    protected void run() {
        Employee employee = composeEmployee(employeeId, employeeRequest);
        employeeService.save(employee);
    }

    private Employee composeEmployee(Integer employeeId, EmployeeRequest employeeRequest) {
        Employee employee = employeeService.findById(employeeId);
        employee.setIdentificationNumber(employeeRequest.getIdentificationNumber());
        employee.setFirstName(employeeRequest.getFirstName());
        employee.setLastName(employeeRequest.getLastName());
        employee.setDateOfBirth(employeeRequest.getDateOfBirth());
        employee.setGender(employeeRequest.getGender());
        employee.setStartDateInCompany(employeeRequest.getStartDateInCompany());
        employee.setHealthConditionStartingAtCompany(employeeRequest.getHealthConditionStartingAtCompany());
        employee.setPhoto(employeeRequest.getPhoto());
        /*employee.setSupervisor(employeeRequest.getSupervisor());
        employee.setRoleEmployee(employeeRequest.getRoleEmployee());
        employee.setDepartmentEmployee(employeeRequest.getDepartmentEmployee());*/
        return employee;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public void setEmployeeRequest(EmployeeRequest employeeRequest) {
        this.employeeRequest = employeeRequest;
    }
}
