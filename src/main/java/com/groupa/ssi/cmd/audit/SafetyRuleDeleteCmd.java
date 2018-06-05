package com.groupa.ssi.cmd.audit;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.services.audit.SafetyRuleService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Neyber Rojas Zapata
 */
@CommandScoped
public class SafetyRuleDeleteCmd extends AbstractCommand {

    private Integer safetyRuleId;

    @Autowired
    private SafetyRuleService safetyRuleService;

    @Override
    protected void run() {
        safetyRuleService.procedureDeleteById(safetyRuleId);
    }

    public void setSafetyRuleId(Integer safetyRuleId) {
        this.safetyRuleId = safetyRuleId;
    }
}
