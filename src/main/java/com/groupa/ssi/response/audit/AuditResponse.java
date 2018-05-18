package com.groupa.ssi.response.audit;

import com.groupa.ssi.model.domain.personnel.Department;
import com.groupa.ssi.model.domain.personnel.Employee;

/**
 * @author Neyber Rojas Zapata
 */
public class AuditResponse {

    private Integer auditId;
    private String auditName;
    private String auditCode;
    private String auditType;
    private String auditScope;
    private String auditObjective;
    private String auditCriteria;
    private String periodicity;
    private Employee employee;
    private Department department;

    public Integer getAuditId() {
        return auditId;
    }

    public void setAuditId(Integer auditId) {
        this.auditId = auditId;
    }

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
