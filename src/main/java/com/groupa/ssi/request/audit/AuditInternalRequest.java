package com.groupa.ssi.request.audit;

/**
 * @author Neyber Rojas Zapata
 */
public class AuditInternalRequest {

    private String auditInternalName;
    private String auditInternalCode;
    private String auditInternalScope;
    private String auditInternalObjective;
    private String auditInternalCriteria;

    public String getAuditInternalName() {
        return auditInternalName;
    }

    public void setAuditInternalName(String auditInternalName) {
        this.auditInternalName = auditInternalName;
    }

    public String getAuditInternalCode() {
        return auditInternalCode;
    }

    public void setAuditInternalCode(String auditInternalCode) {
        this.auditInternalCode = auditInternalCode;
    }

    public String getAuditInternalScope() {
        return auditInternalScope;
    }

    public void setAuditInternalScope(String auditInternalScope) {
        this.auditInternalScope = auditInternalScope;
    }

    public String getAuditInternalObjective() {
        return auditInternalObjective;
    }

    public void setAuditInternalObjective(String auditInternalObjective) {
        this.auditInternalObjective = auditInternalObjective;
    }

    public String getAuditInternalCriteria() {
        return auditInternalCriteria;
    }

    public void setAuditInternalCriteria(String auditInternalCriteria) {
        this.auditInternalCriteria = auditInternalCriteria;
    }
}
