package com.groupa.ssi.response.audit;

import com.groupa.ssi.model.domain.audit.Audit;
import com.groupa.ssi.model.domain.personnel.Employee;

/**
 * @author Neyber Rojas Zapata
 */
public final class AuditResponseBuilder {

    private Integer auditId;
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
        auditResponse.setAuditId(auditId);
        auditResponse.setAuditName(auditName);
        auditResponse.setAuditCode(auditCode);
        auditResponse.setAuditType(auditType);
        auditResponse.setAuditScope(auditScope);
        auditResponse.setAuditObjective(auditObjective);
        auditResponse.setAuditCriteria(auditCriteria);

        return auditResponse;
    }

    public static AuditResponseBuilder getInstance(Audit audit) {
        AuditResponseBuilder auditResponseBuilder = new AuditResponseBuilder();
        auditResponseBuilder.setAuditId(audit.getId());
        auditResponseBuilder.setAuditName(audit.getAuditName());
        auditResponseBuilder.setAuditCode(audit.getAuditCode());
        auditResponseBuilder.setAuditType(audit.getAuditType());
        auditResponseBuilder.setAuditScope(audit.getAuditScope());
        auditResponseBuilder.setAuditCriteria(audit.getAuditCriteria());
        auditResponseBuilder.setAuditObjective(audit.getAuditObjective());

        return auditResponseBuilder;

    }

    public AuditResponseBuilder setAuditId(Integer auditId) {
        this.auditId = auditId;
        return this;
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
