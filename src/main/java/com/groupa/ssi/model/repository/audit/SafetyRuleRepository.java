package com.groupa.ssi.model.repository.audit;

import com.groupa.ssi.model.domain.audit.SafetyRule;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Neyber Rojas Zapata
 */
public interface SafetyRuleRepository extends JpaRepository<SafetyRule, Integer> {
}
