package com.groupa.ssi.cmd.audit;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.audit.SafetyRule;
import com.groupa.ssi.services.audit.SafetyRuleService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Neyber Rojas Zapata
 */
@CommandScoped
public class SafetyRuleReadCmd extends AbstractCommand {

    private Integer safetyRuleId;

    @Autowired
    private SafetyRuleService safetyRuleService;

    private SafetyRule safetyRule;

    @Override
    protected void run() {
        safetyRule = safetyRuleService.procedureFindById(safetyRuleId);
    }

    public void setSafetyRuleId(Integer safetyRuleId) {
        this.safetyRuleId = safetyRuleId;
    }

    public SafetyRule getSafetyRule() {
        return safetyRule;
    }
}
