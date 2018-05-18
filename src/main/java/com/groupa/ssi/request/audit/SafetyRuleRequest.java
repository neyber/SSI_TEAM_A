package com.groupa.ssi.request.audit;

/**
 * @author Neyber Rojas Zapata
 */
public class SafetyRuleRequest {

    private String policyCode;
    private String policyName;
    private Integer complianceParameter;
    private Integer complianceMetric;
    private Boolean accomplishment;
    private Integer auditId;

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

    public Integer getAuditId() {
        return auditId;
    }

    public void setAuditId(Integer auditId) {
        this.auditId = auditId;
    }
}
