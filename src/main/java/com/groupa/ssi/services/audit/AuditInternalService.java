package com.groupa.ssi.services.audit;

import com.groupa.ssi.exception.DomainEntityNotFoundException;
import com.groupa.ssi.model.domain.audit.AuditInternal;
import com.groupa.ssi.model.repository.audit.AuditInternalRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Neyber Rojas Zapata
 */
@Service
public class AuditInternalService {

    private AuditInternalRepository auditInternalRepository;

    public AuditInternalService(AuditInternalRepository auditInternalRepository) {
        this.auditInternalRepository = auditInternalRepository;
    }

    public List<AuditInternal> findAll() {
        List<AuditInternal> auditInternals = new ArrayList<>();
        auditInternalRepository.findAll().forEach(auditInternals::add);
        return  auditInternals;
    }

    public AuditInternal findById(Integer auditInternalId) {
        return auditInternalRepository.findById(auditInternalId).orElseThrow(() -> new DomainEntityNotFoundException(AuditInternal.class));
    }

    public AuditInternal save(AuditInternal auditInternal) {
        return auditInternalRepository.save(auditInternal);
    }

    public void deleteById(Integer auditInternalId) {
        auditInternalRepository.deleteById(auditInternalId);
    }
}
