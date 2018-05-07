package com.groupa.ssi.model.repository.audit;

import com.groupa.ssi.model.domain.audit.Audit;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Neyber Rojas Zapata
 */
public interface AuditRepository extends JpaRepository<Audit, Integer> {
}
