package com.groupa.ssi.cmd.audit;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.audit.Audit;
import com.groupa.ssi.services.audit.AuditService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Neyber Rojas Zapata
 */
@CommandScoped
public class AuditListCmd extends AbstractCommand {

    @Autowired
    private AuditService auditService;

    private List<Audit> auditList;

    @Override
    protected void run() {
        auditList = auditService.findAll();
    }

    public List<Audit> getAuditList() {
        return auditList;
    }
}
