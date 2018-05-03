package com.groupa.ssi.controller.audit;

import com.groupa.ssi.cmd.audit.AuditUpdateCmd;
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
public class AuditUpdateController extends AuditAbstractController {

    private AuditUpdateCmd auditUpdateCmd;

    public AuditUpdateController(AuditUpdateCmd auditUpdateCmd) {
        this.auditUpdateCmd = auditUpdateCmd;
    }

    @ApiOperation(value = "Update audit")
    @RequestMapping(
            value = "/{auditId}",
            method = RequestMethod.PUT
    )
    public SuccessRestResponse updateAudit(@PathVariable Integer auditId, @RequestBody AuditRequest auditRequest, @RequestParam(value = "userId", required = false) Integer userId) {
        auditUpdateCmd.setAuditId(auditId);
        auditUpdateCmd.setAuditRequest(auditRequest);
        auditUpdateCmd.execute();
        return new SuccessRestResponse();
    }
}
