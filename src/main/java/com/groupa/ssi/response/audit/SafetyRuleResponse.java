package com.groupa.ssi.response.audit;

import com.groupa.ssi.model.domain.audit.Audit;

/**
 * @author Neyber Rojas Zapata
 */
public class SafetyRuleResponse {

    private Integer safetyRuleId;
    private String ruleName;
    private Boolean accomplishment;
    private Audit audit;

    public Integer getSafetyRuleId() {
        return safetyRuleId;
    }

    public void setSafetyRuleId(Integer safetyRuleId) {
        this.safetyRuleId = safetyRuleId;
    }

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
