package com.groupa.ssi.controller.audit;

import com.groupa.ssi.common.response.rest.SuccessRestResponse;
import com.groupa.ssi.request.audit.AuditExternalRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

/**
 * @author Neyber Rojas Zapata
 */
@Api(tags = AuditExternalAbstractController.TAG_NAME, description = AuditInternalAbstractController.DESCRIPTION)
@RestController
@RequestScope
public class AuditExternalCreateController extends AuditExternalAbstractController {

    @ApiOperation(value = "Create Audit External")
    @RequestMapping(method = RequestMethod.POST)
    public SuccessRestResponse createAuditExternal(@RequestBody AuditExternalRequest auditExternalRequest, @RequestParam(value = "userId") Integer userId) {
        return new SuccessRestResponse();
    }
}
