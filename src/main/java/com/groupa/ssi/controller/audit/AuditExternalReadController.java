package com.groupa.ssi.controller.audit;

import com.groupa.ssi.common.response.rest.SingleRestResponse;
import com.groupa.ssi.response.audit.AuditExternalResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

/**
 * @author Neyber Rojas Zapata
 */
@Api(tags = AuditExternalAbstractController.TAG_NAME, description = AuditExternalAbstractController.DESCRIPTION)
@RestController
@RequestScope
public class AuditExternalReadController extends AuditExternalAbstractController {

    @ApiOperation(value = "Read/View AuditExternal")
    @RequestMapping(value = "/{auditExternalId}", method = RequestMethod.GET)
    public SingleRestResponse<AuditExternalResponse> readAuditExternal(@PathVariable Integer auditExternalId, @RequestParam(value = "userId") Integer userId) {
        return new SingleRestResponse<>(new AuditExternalResponse());
    }
}
