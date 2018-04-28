package com.groupa.ssi.services.audit;

import com.groupa.ssi.exception.DomainEntityNotFoundException;
import com.groupa.ssi.model.domain.audit.SafetyRule;
import com.groupa.ssi.model.repository.audit.SafetyRuleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Neyber Rojas Zapata
 */
@Service
public class SafetyRuleService {

    private SafetyRuleRepository safetyRuleRepository;

    public SafetyRuleService(SafetyRuleRepository safetyRuleRepository) {
        this.safetyRuleRepository = safetyRuleRepository;
    }

    public List<SafetyRule> findAll() {
        List<SafetyRule> safetyRules = new ArrayList<>();
        safetyRuleRepository.findAll().forEach(safetyRules::add);
        return safetyRules;
    }

    public SafetyRule findById(Integer safetyRuleId) {
        return safetyRuleRepository.findById(safetyRuleId).orElseThrow(() -> new DomainEntityNotFoundException(SafetyRule.class));
    }

    public SafetyRule save(SafetyRule safetyRule) {
        return safetyRuleRepository.save(safetyRule);
    }

    public  void deleteById(Integer safetyRuleId) {
        safetyRuleRepository.deleteById(safetyRuleId);
    }
}
