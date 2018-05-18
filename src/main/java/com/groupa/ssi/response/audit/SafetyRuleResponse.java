package com.groupa.ssi.response.audit;

import com.groupa.ssi.model.domain.audit.Audit;

/**
 * @author Neyber Rojas Zapata
 */
public class SafetyRuleResponse {

    private Integer safetyRuleId;
    private String policyCode;
    private String policyName;
    private Integer complianceParameter;
    private Integer complianceMetric;
    private Boolean accomplishment;
    private Audit audit;

    public Integer getSafetyRuleId() {
        return safetyRuleId;
    }

    public void setSafetyRuleId(Integer safetyRuleId) {
        this.safetyRuleId = safetyRuleId;
    }

    public String getPolicyCode() {
        return policyCode;
    }

    public void setPolicyCode(String policyCode) {
        this.policyCode = policyCode;
    }

    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    public Integer getComplianceParameter() {
        return complianceParameter;
    }

    public void setComplianceParameter(Integer complianceParameter) {
        this.complianceParameter = complianceParameter;
    }

    public Integer getComplianceMetric() {
        return complianceMetric;
    }

    public void setComplianceMetric(Integer complianceMetric) {
        this.complianceMetric = complianceMetric;
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
