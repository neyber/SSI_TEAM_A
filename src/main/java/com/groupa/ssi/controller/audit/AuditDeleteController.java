package com.groupa.ssi.controller.audit;

import com.groupa.ssi.cmd.audit.AuditDeleteCmd;
import com.groupa.ssi.common.response.rest.SuccessRestResponse;
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
public class AuditDeleteController extends AuditAbstractController {

    private AuditDeleteCmd auditDeleteCmd;

    public AuditDeleteController(AuditDeleteCmd auditDeleteCmd) {
        this.auditDeleteCmd = auditDeleteCmd;
    }

    @ApiOperation(value = "Delete audit")
    @RequestMapping(
            value = "/{auditId}",
            method = RequestMethod.DELETE
    )
    public SuccessRestResponse deleteAudit(@PathVariable Integer auditId, @RequestParam(value = "userId", required = false) Integer userId) {
        auditDeleteCmd.setAuditId(auditId);
        auditDeleteCmd.execute();
        return new SuccessRestResponse();
    }
}
