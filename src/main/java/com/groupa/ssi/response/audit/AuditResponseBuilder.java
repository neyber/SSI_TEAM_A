package com.groupa.ssi.response.audit;

import com.groupa.ssi.model.domain.audit.Audit;

/**
 * @author Neyber Rojas Zapata
 */
public final class AuditResponseBuilder {

    private String auditName;
    private String auditCode;
    private String auditType;
    private String auditScope;
    private String auditObjective;
    private String auditCriteria;

    private AuditResponseBuilder() {

    }

    public AuditResponse build() {
        AuditResponse auditResponse = new AuditResponse();
        auditResponse.setAuditName(auditName);
        auditResponse.setAuditCode(auditCode);
        auditResponse.setAuditType(auditType);
        auditResponse.setAuditScope(auditScope);
        auditResponse.setAuditObjective(auditObjective);
        auditResponse.setAuditCriteria(auditCriteria);

        return auditResponse;
    }

    public static AuditResponseBuilder getInstance(Audit audit) {
        return new AuditResponseBuilder()
                .setAuditName(audit.getAuditName())
                .setAuditCode(audit.getAuditCode())
                .setAuditType(audit.getAuditType())
                .setAuditScope(audit.getAuditScope())
                .setAuditObjective(audit.getAuditObjective())
                .setAuditCriteria(audit.getAuditCriteria());
    }

    public AuditResponseBuilder setAuditName(String auditName) {
        this.auditName = auditName;
        return this;
    }

    public AuditResponseBuilder setAuditCode(String auditCode) {
        this.auditCode = auditCode;
        return this;
    }

    public AuditResponseBuilder setAuditType(String auditType) {
        this.auditType = auditType;
        return this;
    }

    public AuditResponseBuilder setAuditScope(String auditScope) {
        this.auditScope = auditScope;
        return this;
    }

    public AuditResponseBuilder setAuditObjective(String auditObjective) {
        this.auditObjective = auditObjective;
        return this;
    }

    public AuditResponseBuilder setAuditCriteria(String auditCriteria) {
        this.auditCriteria = auditCriteria;
        return this;
    }
}
