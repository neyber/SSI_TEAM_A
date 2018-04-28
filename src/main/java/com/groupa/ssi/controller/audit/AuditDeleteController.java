package com.groupa.ssi.controller.audit;

import com.groupa.ssi.common.response.rest.SuccessRestResponse;
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
public class AuditDeleteController extends AuditAbstractController {

    private AuditService auditService;

    public AuditDeleteController(AuditService auditService) {
        this.auditService = auditService;
    }

    @ApiOperation(value = "Delete audit")
    @RequestMapping(
            value = "/{auditId}",
            method = RequestMethod.DELETE
    )
    public SuccessRestResponse deleteAudit(@PathVariable Integer auditId, @RequestParam(value = "userId") Integer userId) {
        auditService.deletedById(auditId);

        return new SuccessRestResponse();
    }
}
