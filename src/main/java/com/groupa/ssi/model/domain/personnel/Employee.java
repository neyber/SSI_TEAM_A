package com.groupa.ssi.model.domain.personnel;

import com.groupa.ssi.model.domain.ModelBase;
import com.groupa.ssi.model.domain.common.FileDocument;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.Date;

/**
 * @author Lizeth Salazar
 */

@Entity
public class Employee extends ModelBase {
    @Column
    private Long identificationNumber;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private Date dateOfBirth;
    @Column
    private char gender;
    @Column
    private Date startDateInCompany;
    @ManyToOne(optional = false)
    private Role roleEmployee;
    @ManyToOne
    private Employee supervisor;
    @ManyToOne
    private Department departmentEmployee;
    @Column
    private String healthConditionStartingAtCompany;

    @ManyToOne
    private FileDocument photoFileDocument;

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

    public FileDocument getPhotoFileDocument() {
        return photoFileDocument;
    }

    public void setPhotoFileDocument(FileDocument photoFileDocument) {
        this.photoFileDocument = photoFileDocument;
    }
}
