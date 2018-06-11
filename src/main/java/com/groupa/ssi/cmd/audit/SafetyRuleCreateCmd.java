package com.groupa.ssi.cmd.audit;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.audit.Audit;
import com.groupa.ssi.model.domain.audit.SafetyRule;
import com.groupa.ssi.request.audit.SafetyRuleRequest;
import com.groupa.ssi.services.audit.AuditService;
import com.groupa.ssi.services.audit.SafetyRuleService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Neyber Rojas Zapata
 */
@CommandScoped
public class SafetyRuleCreateCmd extends AbstractCommand {

    private SafetyRuleRequest safetyRuleRequest;

    @Autowired
    private SafetyRuleService safetyRuleService;
    @Autowired
    private AuditService auditService;

    @Override
    protected void run() {
        Audit audit = null;

        if (safetyRuleRequest.getAuditId() != null) {
            audit = auditService.procedureFindById(safetyRuleRequest.getAuditId());
        }

        SafetyRule safetyRule = ComposeSafetyRule(safetyRuleRequest, audit);
        safetyRuleService.procedureCreate(safetyRule);
    }

    private SafetyRule ComposeSafetyRule(SafetyRuleRequest safetyRuleRequest, Audit audit) {
        SafetyRule safetyRule = new SafetyRule();
        safetyRule.setPolicyCode(safetyRuleRequest.getPolicyCode());
        safetyRule.setPolicyName(safetyRuleRequest.getPolicyName());
        safetyRule.setComplianceParameter(safetyRuleRequest.getComplianceParameter());
        safetyRule.setComplianceMetric(safetyRuleRequest.getComplianceMetric());
        safetyRule.setAccomplishment(accomplishmentByCompliance(safetyRuleRequest));
        safetyRule.setAudit(audit);

        return safetyRule;
    }

    public void setSafetyRuleRequest(SafetyRuleRequest safetyRuleRequest) {
        this.safetyRuleRequest = safetyRuleRequest;
    }

    private Boolean accomplishmentByCompliance(SafetyRuleRequest safetyRuleRequest) {
        if (safetyRuleRequest.getComplianceMetric() >= safetyRuleRequest.getComplianceParameter()) {
            return true;
        }

        return false;
    }
}
