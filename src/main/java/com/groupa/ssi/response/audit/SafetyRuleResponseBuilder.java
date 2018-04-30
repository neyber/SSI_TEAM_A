package com.groupa.ssi.response.audit;

import com.groupa.ssi.model.domain.audit.Audit;
import com.groupa.ssi.model.domain.audit.SafetyRule;

/**
 * @author Neyber Rojas Zapata
 */
public final class SafetyRuleResponseBuilder {

    private Integer safetyRuleId;
    private String ruleName;
    private Boolean accomplishment;

    public SafetyRuleResponseBuilder() {

    }

    public SafetyRuleResponse build() {
        SafetyRuleResponse safetyRuleResponse = new SafetyRuleResponse();
        safetyRuleResponse.setSafetyRuleId(safetyRuleId);
        safetyRuleResponse.setRuleName(ruleName);
        safetyRuleResponse.setAccomplishment(accomplishment);

        return safetyRuleResponse;
    }

    public static SafetyRuleResponseBuilder getInstance(SafetyRule safetyRule) {
        SafetyRuleResponseBuilder safetyRuleResponseBuilder = new SafetyRuleResponseBuilder();
        safetyRuleResponseBuilder.setSafetyRuleId(safetyRule.getId());
        safetyRuleResponseBuilder.setRuleName(safetyRule.getRuleName());
        safetyRuleResponseBuilder.setAccomplishment(safetyRule.getAccomplishment());

        return safetyRuleResponseBuilder;
    }

    public SafetyRuleResponseBuilder setSafetyRuleId(Integer safetyRuleId) {
        this.safetyRuleId = safetyRuleId;
        return this;
    }

    public SafetyRuleResponseBuilder setRuleName(String ruleName) {
        this.ruleName = ruleName;
        return this;
    }

    public SafetyRuleResponseBuilder setAccomplishment(Boolean accomplishment) {
        this.accomplishment = accomplishment;
        return this;
    }
}
