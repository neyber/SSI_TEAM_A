package com.groupa.ssi.cmd.Personnel;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.personnel.Department;
import com.groupa.ssi.model.domain.personnel.Employee;
import com.groupa.ssi.model.domain.personnel.Role;
import com.groupa.ssi.request.personnel.EmployeeRequest;
import com.groupa.ssi.services.personnel.DepartmentService;
import com.groupa.ssi.services.personnel.EmployeeService;
import com.groupa.ssi.services.personnel.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Lizeth Salazar
 */

@CommandScoped
public class EmployeeCreateCmd extends AbstractCommand {
    private EmployeeRequest employeeRequest;

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private DepartmentService departmentService;

    @Override
    protected void run() {
        Role roleEmployee = null;
        Department department = null;
        Employee supervisor = null;

        if(employeeRequest.getRoleId() != null) {
            roleEmployee = roleService.findById(employeeRequest.getRoleId());
        }
        if(employeeRequest.getDepartmentId() != null) {
            department = departmentService.findById(employeeRequest.getDepartmentId());
        }
        if (employeeRequest.getSupervisorId() != null){
            supervisor = employeeService.findById(employeeRequest.getSupervisorId());
        }

        Employee employee = ComposeEmployee(employeeRequest, roleEmployee, department, supervisor);

        employeeService.save(employee);
    }

    private Employee ComposeEmployee(EmployeeRequest employeeRequest, Role role, Department department, Employee supervisor) {
        Employee employee = new Employee();
        employee.setIdentificationNumber(employeeRequest.getIdentificationNumber());
        employee.setFirstName(employeeRequest.getFirstName());
        employee.setLastName(employeeRequest.getLastName());
        employee.setDateOfBirth(employeeRequest.getDateOfBirth());
        employee.setGender(employeeRequest.getGender());
        employee.setStartDateInCompany(employeeRequest.getStartDateInCompany());
        employee.setHealthConditionStartingAtCompany(employeeRequest.getHealthConditionStartingAtCompany());
        employee.setPhoto(employeeRequest.getPhoto());
        employee.setRoleEmployee(role);
        employee.setDepartmentEmployee(department);
        employee.setSupervisor(supervisor);

        return employee;
    }

    public void setEmployeeRequest(EmployeeRequest employeeRequest) {
        this.employeeRequest = employeeRequest;
    }
}
