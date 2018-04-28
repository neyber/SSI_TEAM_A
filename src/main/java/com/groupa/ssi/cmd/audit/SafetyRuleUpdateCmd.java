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
        safetyRuleService.save(safetyRule);
    }

    public void setSafetyRuleId(Integer safetyRuleId) {
        this.safetyRuleId = safetyRuleId;
    }

    public void setSafetyRuleRequest(SafetyRuleRequest safetyRuleRequest) {
        this.safetyRuleRequest = safetyRuleRequest;
    }

    private SafetyRule composeSafetyRule(Integer safetyRuleId, SafetyRuleRequest safetyRuleRequest) {
        SafetyRule safetyRule = safetyRuleService.findById(safetyRuleId);
        safetyRule.setRuleName(safetyRuleRequest.getRuleName());
        safetyRule.setAccomplishment(safetyRuleRequest.getAccomplishment());
        safetyRule.setAudit(safetyRuleRequest.getAudit());
        return safetyRule;
    }
}
