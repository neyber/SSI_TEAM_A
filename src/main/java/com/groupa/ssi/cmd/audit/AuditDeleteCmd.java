package com.groupa.ssi.cmd.audit;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.services.audit.AuditService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Neyber Rojas Zapata
 */
@CommandScoped
public class AuditDeleteCmd extends AbstractCommand {

    private Integer auditId;

    @Autowired
    private AuditService auditService;

    @Override
    protected void run() {
        auditService.procedureDeleteById(auditId);
    }

    public void setAuditId(Integer auditId) {
        this.auditId = auditId;
    }
}
