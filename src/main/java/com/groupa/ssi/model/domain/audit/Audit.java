package com.groupa.ssi.model.domain.audit;

import com.groupa.ssi.model.domain.ModelBase;
import com.groupa.ssi.model.domain.personnel.Department;
import com.groupa.ssi.model.domain.personnel.Employee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Neyber Rojas Zapata
 */
@Entity
public class Audit extends ModelBase {

    @Column
    private String auditName;
    @Column
    private String auditCode;
    @Column
    private String auditType;
    @Column
    private String auditScope;
    @Column
    private String auditObjective;
    @Column
    private String auditCriteria;
    @Column
    private String periodicity;
    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "departmentId")
    private Department department;

    public String getAuditName() {
        return auditName;
    }

    public void setAuditName(String auditName) {
        this.auditName = auditName;
    }

    public String getAuditCode() {
        return auditCode;
    }

    public void setAuditCode(String auditCode) {
        this.auditCode = auditCode;
    }

    public String getAuditType() {
        return auditType;
    }

    public void setAuditType(String auditType) {
        this.auditType = auditType;
    }

    public String getAuditScope() {
        return auditScope;
    }

    public void setAuditScope(String auditScope) {
        this.auditScope = auditScope;
    }

    public String getAuditObjective() {
        return auditObjective;
    }

    public void setAuditObjective(String auditObjective) {
        this.auditObjective = auditObjective;
    }

    public String getAuditCriteria() {
        return auditCriteria;
    }

    public void setAuditCriteria(String auditCriteria) {
        this.auditCriteria = auditCriteria;
    }

    public String getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(String periodicity) {
        this.periodicity = periodicity;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
