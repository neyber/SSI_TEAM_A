package com.groupa.ssi.services.audit;

import com.groupa.ssi.model.domain.audit.Audit;
import com.groupa.ssi.model.repository.audit.AuditRepository;
import com.groupa.ssi.services.common.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * @author Neyber Rojas Zapata
 */
@Service
public class AuditService extends GenericService<Audit> {

    @Autowired
    private AuditRepository auditRepository;

    @Override
    protected JpaRepository<Audit, Integer> getRepository() {
        return auditRepository;
    }
}
