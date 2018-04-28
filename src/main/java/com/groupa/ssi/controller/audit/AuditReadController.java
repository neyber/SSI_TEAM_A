package com.groupa.ssi.controller.audit;

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

    private AuditService auditService;

    public AuditReadController(AuditService auditService) {
        this.auditService = auditService;
    }

    @ApiOperation(value = "Read an audit")
    @RequestMapping(
            value = "/{auditId}",
            method = RequestMethod.GET
    )
    public SingleRestResponse<AuditResponse> readAudit(@PathVariable Integer auditId, @RequestParam(value = "userId") Integer userId) {
        Audit audit = auditService.findById(auditId);

        return new SingleRestResponse<>(AuditResponseBuilder.getInstance(audit).build());
    }
}
