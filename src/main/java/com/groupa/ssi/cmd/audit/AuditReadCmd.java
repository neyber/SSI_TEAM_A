package com.groupa.ssi.cmd.audit;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.audit.Audit;
import com.groupa.ssi.services.audit.AuditService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Neyber Rojas Zapata
 */
@CommandScoped
public class AuditReadCmd extends AbstractCommand {

    private Integer auditId;

    @Autowired
    private AuditService auditService;

    private Audit audit;

    @Override
    protected void run() {
        audit = auditService.findById(auditId);
    }

    public void setAuditId(Integer auditId) {
        this.auditId = auditId;
    }

    public Audit getAudit() {
        return audit;
    }
}
