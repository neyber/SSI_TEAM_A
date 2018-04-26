package com.groupa.ssi.response.personnel;

import com.groupa.ssi.model.domain.personnel.Department;
import com.groupa.ssi.model.domain.personnel.Employee;
import com.groupa.ssi.model.domain.personnel.Role;

import java.util.Date;

/**
 * @author Lizeth Salazar
 */

public class EmployeeResponseBuilder {
    private Long identificationNumber;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private char gender;
    private Date startDateInCompany;
    private Role roleEmployee;
    private Employee supervisor;
    private Department departmentEmployee;
    private String healthConditions;

    public EmployeeResponseBuilder(){}

    public EmployeeResponse build(){
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setIdentificationNumber(identificationNumber);
        employeeResponse.setFirstName(firstName);
        employeeResponse.setLastName(lastName);
        employeeResponse.setDateOfBirth(dateOfBirth);
        employeeResponse.setGender(gender);
        employeeResponse.setStartDateInCompany(startDateInCompany);
        employeeResponse.setRoleEmployee(roleEmployee);
        employeeResponse.setSupervisor(supervisor);
        employeeResponse.setDepartmentEmployee(departmentEmployee);
        employeeResponse.setHealthConditions(healthConditions);
        return employeeResponse;
    }

    public static EmployeeResponseBuilder getInstance(Employee employee){
        EmployeeResponseBuilder employeeResponseBuilder = new EmployeeResponseBuilder();
        employeeResponseBuilder.setIdentificationNumber(employee.getIdentificationNumber());
        employeeResponseBuilder.setFirstName(employee.getFirstName());
        employeeResponseBuilder.setLastName(employee.getLastName());
        employeeResponseBuilder.setDateOfBirth(employee.getDateOfBirth());
        employeeResponseBuilder.setGender(employee.getGender());
        employeeResponseBuilder.setStartDateInCompany(employee.getStartDateInCompany());
        employeeResponseBuilder.setRoleEmployee(employee.getRoleEmployee());
        employeeResponseBuilder.setSupervisor(employee.getSupervisor());
        employeeResponseBuilder.setDepartmentEmployee(employee.getDepartmentEmployee());
        employeeResponseBuilder.setHealthConditions(employee.getHealthConditions());
        return employeeResponseBuilder;
    }


    public void setIdentificationNumber(Long identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setStartDateInCompany(Date startDateInCompany) {
        this.startDateInCompany = startDateInCompany;
    }

    public void setRoleEmployee(Role roleEmployee) {
        this.roleEmployee = roleEmployee;
    }

    public void setSupervisor(Employee supervisor) {
        this.supervisor = supervisor;
    }

    public void setDepartmentEmployee(Department departmentEmployee) {
        this.departmentEmployee = departmentEmployee;
    }

    public void setHealthConditions(String healthConditions) {
        this.healthConditions = healthConditions;
    }
}
