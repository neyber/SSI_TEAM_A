package com.groupa.ssi.model.repository.audit;

import com.groupa.ssi.model.domain.audit.AuditExternal;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Neyber Rojas Zapata
 */
public interface AuditExternalRepository extends JpaRepository<AuditExternal, Integer> {
}
