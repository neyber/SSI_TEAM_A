package com.groupa.ssi.response.personnel;

import com.groupa.ssi.model.domain.personnel.Department;
import com.groupa.ssi.model.domain.personnel.Employee;
import com.groupa.ssi.model.domain.personnel.Role;

import java.util.Date;

/**
 * @author Lizeth Salazar
 */

public class EmployeeResponse {
    private Long identificationNumber;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private char gender;
    private Date startDateInCompany;
    private Role roleEmployee;
    private Employee supervisor;
    private Department departmentEmployee;
    private String healthConditionStartingAtCompany;
    private Byte[] photo;

    public Long getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(Long identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Date getStartDateInCompany() {
        return startDateInCompany;
    }

    public void setStartDateInCompany(Date startDateInCompany) {
        this.startDateInCompany = startDateInCompany;
    }

    public Role getRoleEmployee() {
        return roleEmployee;
    }

    public void setRoleEmployee(Role roleEmployee) {
        this.roleEmployee = roleEmployee;
    }

    public Employee getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Employee supervisor) {
        this.supervisor = supervisor;
    }

    public Department getDepartmentEmployee() {
        return departmentEmployee;
    }

    public void setDepartmentEmployee(Department departmentEmployee) {
        this.departmentEmployee = departmentEmployee;
    }

    public String getHealthConditionStartingAtCompany() {
        return healthConditionStartingAtCompany;
    }

    public void setHealthConditionStartingAtCompany(String healthConditionStartingAtCompany) {
        this.healthConditionStartingAtCompany = healthConditionStartingAtCompany;
    }

    public Byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(Byte[] photo) {
        this.photo = photo;
    }
}
