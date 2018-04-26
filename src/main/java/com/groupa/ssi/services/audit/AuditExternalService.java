package com.groupa.ssi.services.audit;

import com.groupa.ssi.exception.DomainEntityNotFoundException;
import com.groupa.ssi.model.domain.audit.AuditExternal;
import com.groupa.ssi.model.repository.audit.AuditExternalRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Neyber Rojas Zapata
 */
@Service
public class AuditExternalService {

    private AuditExternalRepository auditExternalRepository;

    public AuditExternalService(AuditExternalRepository auditExternalRepository) {
        this.auditExternalRepository = auditExternalRepository;
    }

    public List<AuditExternal> findAll() {
        List<AuditExternal> auditExternals = new ArrayList<>();
        auditExternalRepository.findAll().forEach(auditExternals::add);
        return  auditExternals;
    }

    public AuditExternal findById(Integer auditExternalId) {
        return auditExternalRepository.findById(auditExternalId).orElseThrow(() -> new DomainEntityNotFoundException(AuditExternal.class));
    }

    public AuditExternal save(AuditExternal auditExternal) {
        return auditExternalRepository.save(auditExternal);
    }

    public void deleteById(Integer auditExternalId) {
        auditExternalRepository.deleteById(auditExternalId);
    }
}
