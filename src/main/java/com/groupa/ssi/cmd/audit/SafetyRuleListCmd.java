package com.groupa.ssi.cmd.audit;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.audit.SafetyRule;
import com.groupa.ssi.services.audit.SafetyRuleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Neyber Rojas Zapata
 */
@CommandScoped
public class SafetyRuleListCmd extends AbstractCommand {

    @Autowired
    private SafetyRuleService safetyRuleService;

    private List<SafetyRule> safetyRuleList;

    @Override
    protected void run() {
        safetyRuleList = safetyRuleService.findAll();
    }

    public List<SafetyRule> getSafetyRuleList() {
        return safetyRuleList;
    }
}
