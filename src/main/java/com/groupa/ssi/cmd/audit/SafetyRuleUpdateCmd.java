package com.groupa.ssi.cmd.audit;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.audit.SafetyRule;
import com.groupa.ssi.request.audit.SafetyRuleRequest;
import com.groupa.ssi.services.audit.SafetyRuleService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Neyber Rojas Zapata
 */
@CommandScoped
public class SafetyRuleUpdateCmd extends AbstractCommand {

    private Integer safetyRuleId;
    private SafetyRuleRequest safetyRuleRequest;

    @Autowired
    private SafetyRuleService safetyRuleService;

    @Override
    protected void run() {
        SafetyRule safetyRule = composeSafetyRule(safetyRuleId, safetyRuleRequest);
        safetyRuleService.procedureUpdate(safetyRule);
    }

    public void setSafetyRuleId(Integer safetyRuleId) {
        this.safetyRuleId = safetyRuleId;
    }

    public void setSafetyRuleRequest(SafetyRuleRequest safetyRuleRequest) {
        this.safetyRuleRequest = safetyRuleRequest;
    }

    private SafetyRule composeSafetyRule(Integer safetyRuleId, SafetyRuleRequest safetyRuleRequest) {
        SafetyRule safetyRule = safetyRuleService.procedureFindById(safetyRuleId);
        safetyRule.setPolicyCode(safetyRuleRequest.getPolicyCode());
        safetyRule.setPolicyName(safetyRuleRequest.getPolicyName());
        safetyRule.setComplianceParameter(safetyRuleRequest.getComplianceParameter());
        safetyRule.setComplianceMetric(safetyRuleRequest.getComplianceMetric());
        safetyRule.setAccomplishment(accomplishmentByCompliance(safetyRuleRequest));

        return safetyRule;
    }

    private Boolean accomplishmentByCompliance(SafetyRuleRequest safetyRuleRequest) {
        if (safetyRuleRequest.getComplianceMetric() >= safetyRuleRequest.getComplianceParameter()) {
            return true;
        }

        return false;
    }
}
