package com.groupa.ssi.controller.audit;

import com.groupa.ssi.cmd.audit.AuditReadCmd;
import com.groupa.ssi.common.response.rest.SingleRestResponse;
import com.groupa.ssi.model.domain.audit.Audit;
import com.groupa.ssi.response.audit.AuditResponse;
import com.groupa.ssi.response.audit.AuditResponseBuilder;
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
public class AuditReadController extends AuditAbstractController {

    private AuditReadCmd auditReadCmd;

    public AuditReadController(AuditReadCmd auditReadCmd) {
        this.auditReadCmd = auditReadCmd;
    }

    @ApiOperation(value = "Read an audit")
    @RequestMapping(
            value = "/{auditId}",
            method = RequestMethod.GET
    )
    public SingleRestResponse<AuditResponse> readAudit(@PathVariable Integer auditId, @RequestParam(value = "userId", required = false) Integer userId) {
        auditReadCmd.setAuditId(auditId);
        auditReadCmd.execute();
        return new SingleRestResponse<>(AuditResponseBuilder.getInstance(auditReadCmd.getAudit()).build());
    }
}
