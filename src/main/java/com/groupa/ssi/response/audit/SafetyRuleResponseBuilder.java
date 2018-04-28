package com.groupa.ssi.response.audit;

import com.groupa.ssi.model.domain.audit.Audit;
import com.groupa.ssi.model.domain.audit.SafetyRule;

/**
 * @author Neyber Rojas Zapata
 */
public final class SafetyRuleResponseBuilder {

    private String ruleName;
    private Boolean accomplishment;
    private Audit audit;

    public SafetyRuleResponseBuilder() {

    }

    public SafetyRuleResponse build() {
        SafetyRuleResponse safetyRuleResponse = new SafetyRuleResponse();
        safetyRuleResponse.setRuleName(ruleName);
        safetyRuleResponse.setAccomplishment(accomplishment);
        safetyRuleResponse.setAudit(audit);

        return safetyRuleResponse;
    }

    public static SafetyRuleResponseBuilder getInstance(SafetyRule safetyRule) {
        return new SafetyRuleResponseBuilder()
                .setRuleName(safetyRule.getRuleName())
                .setAccomplishment(safetyRule.getAccomplishment())
                .setAudit(safetyRule.getAudit());
    }

    public SafetyRuleResponseBuilder setRuleName(String ruleName) {
        this.ruleName = ruleName;
        return this;
    }

    public SafetyRuleResponseBuilder setAccomplishment(Boolean accomplishment) {
        this.accomplishment = accomplishment;
        return this;
    }

    public SafetyRuleResponseBuilder setAudit(Audit audit) {
        this.audit = audit;
        return this;
    }
}
