package com.groupa.ssi.request.audit;

/**
 * @author Neyber Rojas Zapata
 */
public class AuditExternalRequest {

    private String auditExternalName;
    private String auditExternalCode;
    private String auditExternalScope;
    private String auditExternalObjective;
    private String auditExternalCriteria;

    public String getAuditExternalName() {
        return auditExternalName;
    }

    public void setAuditExternalName(String auditExternalName) {
        this.auditExternalName = auditExternalName;
    }

    public String getAuditExternalCode() {
        return auditExternalCode;
    }

    public void setAuditExternalCode(String auditExternalCode) {
        this.auditExternalCode = auditExternalCode;
    }

    public String getAuditExternalScope() {
        return auditExternalScope;
    }

    public void setAuditExternalScope(String auditExternalScope) {
        this.auditExternalScope = auditExternalScope;
    }

    public String getAuditExternalObjective() {
        return auditExternalObjective;
    }

    public void setAuditExternalObjective(String auditExternalObjective) {
        this.auditExternalObjective = auditExternalObjective;
    }

    public String getAuditExternalCriteria() {
        return auditExternalCriteria;
    }

    public void setAuditExternalCriteria(String auditExternalCriteria) {
        this.auditExternalCriteria = auditExternalCriteria;
    }
}
