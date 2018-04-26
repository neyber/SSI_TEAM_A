package com.groupa.ssi.response.audit;

import com.groupa.ssi.model.domain.audit.AuditExternal;

/**
 * @author Neyber Rojas Zapata
 */
public class AuditExternalResponseBuilder {

    private String auditExternalName;
    private String auditExternalCode;
    private String auditExternalScope;
    private String auditExternalObjective;
    private String auditExternalCriteria;

    private AuditExternalResponseBuilder() {

    }

    public AuditExternalResponse build() {
        AuditExternalResponse auditExternalResponse = new AuditExternalResponse();
        auditExternalResponse.setAuditExternalName(auditExternalName);
        auditExternalResponse.setAuditExternalCode(auditExternalCode);
        auditExternalResponse.setAuditExternalScope(auditExternalScope);
        auditExternalResponse.setAuditExternalObjective(auditExternalObjective);
        auditExternalResponse.setAuditExternalCriteria(auditExternalCriteria);

        return auditExternalResponse;
    }

    public static AuditExternalResponseBuilder getInstance(AuditExternal auditExternal) {
        AuditExternalResponseBuilder auditExternalResponseBuilder = new AuditExternalResponseBuilder();
        auditExternalResponseBuilder.setAuditExternalName(auditExternal.getAuditInternalName());
        auditExternalResponseBuilder.setAuditExternalCode(auditExternal.getAuditInternalCode());
        auditExternalResponseBuilder.setAuditExternalScope(auditExternal.getAuditInternalScope());
        auditExternalResponseBuilder.setAuditExternalObjective(auditExternal.getAuditInternalObjective());
        auditExternalResponseBuilder.setAuditExternalCriteria(auditExternal.getAuditInternalCriteria());

        return auditExternalResponseBuilder;
    }

    public void setAuditExternalName(String auditExternalName) {
        this.auditExternalName = auditExternalName;
    }

    public void setAuditExternalCode(String auditExternalCode) {
        this.auditExternalCode = auditExternalCode;
    }

    public void setAuditExternalScope(String auditExternalScope) {
        this.auditExternalScope = auditExternalScope;
    }

    public void setAuditExternalObjective(String auditExternalObjective) {
        this.auditExternalObjective = auditExternalObjective;
    }

    public void setAuditExternalCriteria(String auditExternalCriteria) {
        this.auditExternalCriteria = auditExternalCriteria;
    }
}
