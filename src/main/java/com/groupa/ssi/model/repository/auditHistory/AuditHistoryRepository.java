package com.groupa.ssi.model.repository.auditHistory;

import com.groupa.ssi.model.domain.auditHistory.AuditHistory_SSI;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Lizeth Salazar
 */

public interface AuditHistoryRepository extends JpaRepository<AuditHistory_SSI, Integer> {
}
