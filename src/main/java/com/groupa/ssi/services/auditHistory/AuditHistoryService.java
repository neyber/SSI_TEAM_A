package com.groupa.ssi.services.auditHistory;

import com.groupa.ssi.model.domain.auditHistory.AuditHistory_SSI;
import com.groupa.ssi.model.repository.auditHistory.AuditHistoryRepository;
import com.groupa.ssi.services.common.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * @author Lizeth Salazar
 */

@Service
public class AuditHistoryService extends GenericService<AuditHistory_SSI> {

    @Autowired
    private AuditHistoryRepository auditHistoryRepository;

    @Override
    protected JpaRepository<AuditHistory_SSI, Integer> getRepository() {return auditHistoryRepository;}
}
