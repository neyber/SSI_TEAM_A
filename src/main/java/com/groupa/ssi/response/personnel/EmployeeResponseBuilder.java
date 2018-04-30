package com.groupa.ssi.response.personnel;

import com.groupa.ssi.model.domain.personnel.Department;
import com.groupa.ssi.model.domain.personnel.Employee;
import com.groupa.ssi.model.domain.personnel.Role;

import java.util.Date;

/**
 * @author Lizeth Salazar
 */

public final class EmployeeResponseBuilder {
    private Integer employeeId;
    private Long identificationNumber;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private char gender;
    private Date startDateInCompany;
    private RoleResponse roleEmployee;
    private EmployeeResponse supervisor;
    private DepartmentResponse departmentEmployee;
    private String healthConditionStartingAtCompany;
    private Integer photoFileDocumentId;


    private EmployeeResponseBuilder(){}

    public EmployeeResponse build(){
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setEmployeeId(employeeId);
        employeeResponse.setIdentificationNumber(identificationNumber);
        employeeResponse.setFirstName(firstName);
        employeeResponse.setLastName(lastName);
        employeeResponse.setDateOfBirth(dateOfBirth);
        employeeResponse.setGender(gender);
        employeeResponse.setStartDateInCompany(startDateInCompany);
        employeeResponse.setRoleEmployee(roleEmployee);
        employeeResponse.setSupervisor(supervisor);
        employeeResponse.setDepartmentEmployee(departmentEmployee);
        employeeResponse.setHealthConditionStartingAtCompany(healthConditionStartingAtCompany);
        employeeResponse.setPhotoFileDocumentId(photoFileDocumentId);
        return employeeResponse;
    }

    public static EmployeeResponseBuilder getInstance(Employee employee){
        EmployeeResponseBuilder employeeResponseBuilder = new EmployeeResponseBuilder();
        employeeResponseBuilder.setEmployeeId(employee.getId());
        employeeResponseBuilder.setIdentificationNumber(employee.getIdentificationNumber());
        employeeResponseBuilder.setFirstName(employee.getFirstName());
        employeeResponseBuilder.setLastName(employee.getLastName());
        employeeResponseBuilder.setDateOfBirth(employee.getDateOfBirth());
        employeeResponseBuilder.setGender(employee.getGender());
        employeeResponseBuilder.setStartDateInCompany(employee.getStartDateInCompany());

        if (employee.getRoleEmployee() != null) {
            employeeResponseBuilder.setRoleEmployee(RoleResponseBuilder.getInstance(employee.getRoleEmployee()).build());
        }

        if (employee.getSupervisor() != null) {
            employeeResponseBuilder.setSupervisor(EmployeeResponseBuilder.getInstance(employee.getSupervisor()).build());
        }

        if (employee.getDepartmentEmployee() != null) {
            employeeResponseBuilder.setDepartmentEmployee(DepartmentResponseBuilder.getInstance(employee.getDepartmentEmployee()).build());
        }

        employeeResponseBuilder.setHealthConditionStartingAtCompany(employee.getHealthConditionStartingAtCompany());

        if (employee.getPhotoFileDocument() != null) {
            employeeResponseBuilder.setPhotoFileDocumentId(employee.getPhotoFileDocument().getId());
        }

        return employeeResponseBuilder;
    }

    public EmployeeResponseBuilder setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    public EmployeeResponseBuilder setIdentificationNumber(Long identificationNumber) {
        this.identificationNumber = identificationNumber;
        return this;
    }

    public EmployeeResponseBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public EmployeeResponseBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public EmployeeResponseBuilder setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public EmployeeResponseBuilder setGender(char gender) {
        this.gender = gender;
        return this;
    }

    public EmployeeResponseBuilder setStartDateInCompany(Date startDateInCompany) {
        this.startDateInCompany = startDateInCompany;
        return this;
    }

    public EmployeeResponseBuilder setRoleEmployee(RoleResponse roleEmployee) {
        this.roleEmployee = roleEmployee;
        return this;
    }

    public EmployeeResponseBuilder setSupervisor(EmployeeResponse supervisor) {
        this.supervisor = supervisor;
        return this;
    }

    public EmployeeResponseBuilder setDepartmentEmployee(DepartmentResponse departmentEmployee) {
        this.departmentEmployee = departmentEmployee;
        return this;
    }

    public EmployeeResponseBuilder setHealthConditionStartingAtCompany(String healthConditionStartingAtCompany) {
        this.healthConditionStartingAtCompany = healthConditionStartingAtCompany;
        return this;
    }

    public EmployeeResponseBuilder setPhotoFileDocumentId(Integer photoFileDocumentId) {
        this.photoFileDocumentId = photoFileDocumentId;
        return this;
    }
}
