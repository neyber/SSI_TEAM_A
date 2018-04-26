package com.groupa.ssi.model.domain.audit;

import com.groupa.ssi.model.domain.ModelBase;

import javax.persistence.*;

/**
 * @author Neyber Rojas Zapata
 */
@Entity
public class AuditInternal extends ModelBase {

    @Column
    private String auditInternalName;

    @Column
    private String auditInternalCode;

    @Column
    private String auditInternalScope;

    @Column
    private String auditInternalObjective;

    @Column
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
