package com.groupa.ssi.services.audit;

import com.groupa.ssi.exception.DomainEntityNotFoundException;
import com.groupa.ssi.model.domain.audit.Audit;
import com.groupa.ssi.model.repository.audit.AuditRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Neyber Rojas Zapata
 */
@Service
public class AuditService {

    private AuditRepository auditRepository;

    public AuditService(AuditRepository auditRepository) {
        this.auditRepository = auditRepository;
    }

    public List<Audit> findAll() {
        List<Audit> audits = new ArrayList<>();
        auditRepository.findAll().forEach(audits::add);
        return audits;
    }

    public Audit findById(Integer auditId) {
        return auditRepository.findById(auditId).orElseThrow(() -> new DomainEntityNotFoundException(Audit.class));
    }

    public Audit save(Audit audit) {
        return auditRepository.save(audit);
    }

    public void deletedById(Integer auditId) {
        auditRepository.deleteById(auditId);
    }
}
