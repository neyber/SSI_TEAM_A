package com.groupa.ssi.services.audit;

import com.groupa.ssi.model.domain.audit.SafetyRule;
import com.groupa.ssi.model.repository.audit.SafetyRuleRepository;
import com.groupa.ssi.services.common.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * @author Neyber Rojas Zapata
 */
@Service
public class SafetyRuleService extends GenericService<SafetyRule> {

    @Autowired
    private SafetyRuleRepository safetyRuleRepository;

    @Override
    protected JpaRepository<SafetyRule, Integer> getRepository() {
        return safetyRuleRepository;
    }
}
