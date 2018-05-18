package com.groupa.ssi.request.audit;

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
    private String periodicity;
    private Integer employeeId;
    private Integer departmentId;

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

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }
}
