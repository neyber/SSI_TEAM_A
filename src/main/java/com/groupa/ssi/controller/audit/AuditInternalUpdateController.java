package com.groupa.ssi.controller.audit;

import com.groupa.ssi.common.response.rest.SuccessRestResponse;
import com.groupa.ssi.request.audit.AuditInternalRequest;
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
public class AuditInternalUpdateController extends AuditInternalAbstractController {

    @ApiOperation(value = "Update auditInternal")
    @RequestMapping(value = "/{auditInternalId}", method = RequestMethod.PUT)
    public SuccessRestResponse updateAuditInternal(@PathVariable Integer auditInternalId, @RequestBody AuditInternalRequest auditInternalRequest, @RequestParam(value = "userId") Integer userId) {
        return new SuccessRestResponse();
    }
}
