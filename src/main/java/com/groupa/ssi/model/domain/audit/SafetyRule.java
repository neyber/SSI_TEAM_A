package com.groupa.ssi.model.domain.audit;

import com.groupa.ssi.model.domain.ModelBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * @author Neyber Rojas Zapata
 */
@Entity
public class SafetyRule extends ModelBase {

    @Column
    private String ruleName;
    @Column
    private Boolean accomplishment;
    @ManyToOne
    private Audit audit;

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public Boolean getAccomplishment() {
        return accomplishment;
    }

    public void setAccomplishment(Boolean accomplishment) {
        this.accomplishment = accomplishment;
    }

    public Audit getAudit() {
        return audit;
    }

    public void setAudit(Audit audit) {
        this.audit = audit;
    }
}
