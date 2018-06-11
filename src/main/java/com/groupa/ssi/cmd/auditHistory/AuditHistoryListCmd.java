package com.groupa.ssi.cmd.auditHistory;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.auditHistory.AuditHistory_SSI;
import com.groupa.ssi.services.auditHistory.AuditHistoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Lizeth Salazar
 */

@CommandScoped
public class AuditHistoryListCmd extends AbstractCommand {

    @Autowired
    private AuditHistoryService auditHistoryService;

    private List<AuditHistory_SSI> auditHistorySSIList;

    @Override
    protected void run() {
        auditHistorySSIList = auditHistoryService.findAll();
    }

    public List<AuditHistory_SSI> getAuditHistorySSIList() {
        return auditHistorySSIList;
    }
}
