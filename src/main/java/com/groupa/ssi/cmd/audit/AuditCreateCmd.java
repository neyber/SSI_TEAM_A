package com.groupa.ssi.cmd.audit;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.audit.Audit;
import com.groupa.ssi.request.audit.AuditRequest;
import com.groupa.ssi.services.audit.AuditService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Neyber Rojas Zapata
 */
@CommandScoped
public class AuditCreateCmd extends AbstractCommand {

    private AuditRequest auditRequest;

    @Autowired
    private AuditService auditService;

    @Override
    protected void run() {
        Audit audit = composeAudit(auditRequest);
        auditService.save(audit);
    }

    public void setAuditRequest(AuditRequest auditRequest) {
        this.auditRequest = auditRequest;
    }

    private Audit composeAudit(AuditRequest auditRequest) {
        Audit audit = new Audit();
        audit.setAuditName(auditRequest.getAuditName());
        audit.setAuditCode(auditRequest.getAuditCode());
        audit.setAuditType(auditRequest.getAuditType());
        audit.setAuditScope(auditRequest.getAuditScope());
        audit.setAuditObjective(auditRequest.getAuditObjective());
        audit.setAuditCriteria(auditRequest.getAuditCriteria());
        audit.setEmployee(auditRequest.getEmployee());

        return audit;
    }
}
