package com.groupa.ssi.controller.audit;

import com.groupa.ssi.common.response.rest.SuccessRestResponse;
import com.groupa.ssi.model.domain.audit.Audit;
import com.groupa.ssi.request.audit.AuditRequest;
import com.groupa.ssi.services.audit.AuditService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

/**
 * @author Neyber Rojas Zapata
 */
@Api(
        tags = AuditAbstractController.TAG_NAME,
        description = AuditAbstractController.DESCRIPTION
)
@RestController
@RequestScope
public class AuditCreateController extends AuditAbstractController {

    private AuditService auditService;

    public AuditCreateController(AuditService auditService) {
        this.auditService = auditService;
    }

    @ApiOperation(value = "Create audit")
    @RequestMapping(
            method = RequestMethod.POST
    )
    public SuccessRestResponse createAudit(@RequestBody AuditRequest auditRequest, @RequestParam(value = "userId") Integer userId) {
        Audit audit = new Audit();
        audit.setAuditName(auditRequest.getAuditName());
        audit.setAuditCode(auditRequest.getAuditCode());
        audit.setAuditType(auditRequest.getAuditType());
        audit.setAuditScope(auditRequest.getAuditScope());
        audit.setAuditObjective(auditRequest.getAuditObjective());
        audit.setAuditCriteria(auditRequest.getAuditCriteria());

        return new SuccessRestResponse();
    }
}
