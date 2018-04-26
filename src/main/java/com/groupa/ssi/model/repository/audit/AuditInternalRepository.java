package com.groupa.ssi.model.repository.audit;

import com.groupa.ssi.model.domain.audit.AuditInternal;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Neyber Rojas Zapata
 */
public interface AuditInternalRepository extends JpaRepository<AuditInternal, Integer> {
}
