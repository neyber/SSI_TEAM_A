package com.groupa.ssi.controller.audit;

import com.groupa.ssi.cmd.audit.AuditCreateCmd;
import com.groupa.ssi.common.response.rest.SuccessRestResponse;
import com.groupa.ssi.request.audit.AuditRequest;
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

    private AuditCreateCmd auditCreateCmd;

    public AuditCreateController(AuditCreateCmd auditCreateCmd) {
        this.auditCreateCmd = auditCreateCmd;
    }

    @ApiOperation(value = "Create audit")
    @RequestMapping(
            method = RequestMethod.POST
    )
    public SuccessRestResponse createAudit(@RequestBody AuditRequest auditRequest, @RequestParam(value = "userId") Integer userId) {
        auditCreateCmd.setAuditRequest(auditRequest);
        auditCreateCmd.execute();
        return new SuccessRestResponse();
    }
}
