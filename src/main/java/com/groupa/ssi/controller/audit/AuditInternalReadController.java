package com.groupa.ssi.controller.audit;

import com.groupa.ssi.common.response.rest.SingleRestResponse;
import com.groupa.ssi.response.audit.AuditInternalResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

/**
 * @author Neyber Rojas Zapata
 */
@Api(tags = AuditInternalAbstractController.TAG_NAME, description = AuditInternalAbstractController.DESCRIPTION)
@RestController
@RequestScope
public class AuditInternalReadController extends AuditInternalAbstractController {

    @ApiOperation(value = "Read/View AuditInternal")
    @RequestMapping(value = "/{auditInternalId}", method = RequestMethod.GET)
    public SingleRestResponse<AuditInternalResponse> readAuditInternal(@PathVariable Integer auditInternalId, @RequestParam(value = "userId") Integer userId) {
        return new SingleRestResponse<>(new AuditInternalResponse());
    }
}
