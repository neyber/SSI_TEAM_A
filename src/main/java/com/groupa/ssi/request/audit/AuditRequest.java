package com.groupa.ssi.request.audit;

import com.groupa.ssi.model.domain.personnel.Employee;

/**
 * @author Neyber Rojas Zapata
 */
public class AuditRequest {

    private String auditName;
    private String auditCode;
    private String auditType;
    private String auditScope;
    private String auditObjective;
    private String auditCriteria;
    private Employee employee;

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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
