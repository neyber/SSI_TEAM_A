package com.groupa.ssi.response.audit;

import com.groupa.ssi.model.domain.audit.SafetyRule;

/**
 * @author Neyber Rojas Zapata
 */
public final class SafetyRuleResponseBuilder {

    private Integer safetyRuleId;
    private String policyCode;
    private String policyName;
    private Integer complianceParameter;
    private Integer complianceMetric;
    private Boolean accomplishment;
    private AuditResponse audit;

    public SafetyRuleResponseBuilder() {

    }

    public SafetyRuleResponse build() {
        SafetyRuleResponse safetyRuleResponse = new SafetyRuleResponse();
        safetyRuleResponse.setSafetyRuleId(safetyRuleId);
        safetyRuleResponse.setPolicyCode(policyCode);
        safetyRuleResponse.setPolicyName(policyName);
        safetyRuleResponse.setComplianceParameter(complianceParameter);
        safetyRuleResponse.setComplianceMetric(complianceMetric);
        safetyRuleResponse.setAccomplishment(accomplishment);
        safetyRuleResponse.setAudit(audit);

        return safetyRuleResponse;
    }

    public static SafetyRuleResponseBuilder getInstance(SafetyRule safetyRule) {
        SafetyRuleResponseBuilder safetyRuleResponseBuilder = new SafetyRuleResponseBuilder();
        safetyRuleResponseBuilder.setSafetyRuleId(safetyRule.getId());
        safetyRuleResponseBuilder.setPolicyCode(safetyRule.getPolicyCode());
        safetyRuleResponseBuilder.setPolicyName(safetyRule.getPolicyName());
        safetyRuleResponseBuilder.setComplianceParameter(safetyRule.getComplianceParameter());
        safetyRuleResponseBuilder.setComplianceMetric(safetyRule.getComplianceMetric());
        safetyRuleResponseBuilder.setAccomplishment(safetyRule.getAccomplishment());

        if(null != safetyRule.getAudit()) {
            safetyRuleResponseBuilder.setAudit(AuditResponseBuilder.getInstance(safetyRule.getAudit()).build());
        }

        return safetyRuleResponseBuilder;
    }

    public SafetyRuleResponseBuilder setSafetyRuleId(Integer safetyRuleId) {
        this.safetyRuleId = safetyRuleId;
        return this;
    }

    public SafetyRuleResponseBuilder setPolicyCode(String policyCode) {
        this.policyCode = policyCode;
        return this;
    }

    public SafetyRuleResponseBuilder setPolicyName(String policyName) {
        this.policyName = policyName;
        return this;
    }

    public SafetyRuleResponseBuilder setComplianceParameter(Integer complianceParameter) {
        this.complianceParameter = complianceParameter;
        return this;
    }

    public SafetyRuleResponseBuilder setComplianceMetric(Integer complianceMetric) {
        this.complianceMetric = complianceMetric;
        return this;
    }

    public SafetyRuleResponseBuilder setAccomplishment(Boolean accomplishment) {
        this.accomplishment = accomplishment;
        return this;
    }

    public SafetyRuleResponseBuilder setAudit(AuditResponse audit) {
        this.audit = audit;
        return this;
    }
}
