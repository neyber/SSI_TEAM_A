package com.groupa.ssi.request.audit;

/**
 * @author Neyber Rojas Zapata
 */
public class SafetyRuleRequest {

    private String ruleName;
    private Boolean accomplishment;
    private Integer auditId;

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

    public Integer getAuditId() {
        return auditId;
    }

    public void setAuditId(Integer auditId) {
        this.auditId = auditId;
    }
}
