package com.groupa.ssi.response.audit;

import com.groupa.ssi.model.domain.audit.AuditInternal;

/**
 * @author Neyber Rojas Zapata
 */
public class AuditInternalResponseBuilder {

    private String auditInternalName;
    private String auditInternalCode;
    private String auditInternalScope;
    private String auditInternalObjective;
    private String auditInternalCriteria;

    private AuditInternalResponseBuilder() {

    }

    public AuditInternalResponse build() {
        AuditInternalResponse auditInternalResponse = new AuditInternalResponse();
        auditInternalResponse.setAuditInternalName(auditInternalName);
        auditInternalResponse.setAuditInternalCode(auditInternalCode);
        auditInternalResponse.setAuditInternalScope(auditInternalScope);
        auditInternalResponse.setAuditInternalObjective(auditInternalObjective);
        auditInternalResponse.setAuditInternalCriteria(auditInternalCriteria);

        return auditInternalResponse;
    }

    public static AuditInternalResponseBuilder getInstance(AuditInternal auditInternal) {
        AuditInternalResponseBuilder auditInternalResponseBuilder = new AuditInternalResponseBuilder();
        auditInternalResponseBuilder.setAuditInternalName(auditInternal.getAuditInternalName());
        auditInternalResponseBuilder.setAuditInternalCode(auditInternal.getAuditInternalCode());
        auditInternalResponseBuilder.setAuditInternalScope(auditInternal.getAuditInternalScope());
        auditInternalResponseBuilder.setAuditInternalObjective(auditInternal.getAuditInternalObjective());
        auditInternalResponseBuilder.setAuditInternalCriteria(auditInternal.getAuditInternalCriteria());

        return auditInternalResponseBuilder;
    }

    public void setAuditInternalName(String auditInternalName) {
        this.auditInternalName = auditInternalName;
    }

    public void setAuditInternalCode(String auditInternalCode) {
        this.auditInternalCode = auditInternalCode;
    }

    public void setAuditInternalScope(String auditInternalScope) {
        this.auditInternalScope = auditInternalScope;
    }

    public void setAuditInternalObjective(String auditInternalObjective) {
        this.auditInternalObjective = auditInternalObjective;
    }

    public void setAuditInternalCriteria(String auditInternalCriteria) {
        this.auditInternalCriteria = auditInternalCriteria;
    }
}
