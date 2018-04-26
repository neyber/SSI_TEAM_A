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
@Api(tags = AuditExternalAbstractController.TAG_NAME, description = AuditExternalAbstractController.DESCRIPTION)
@RestController
@RequestScope
public class AuditExternalUpdateController extends AuditExternalAbstractController {

    @ApiOperation(value = "Update auditExternal")
    @RequestMapping(value = "/{auditExternalId}", method = RequestMethod.PUT)
    public SuccessRestResponse updateAuditExternal(@PathVariable Integer auditExternalId, @RequestBody AuditExternalRequest auditExternalRequest, @RequestParam(value = "userId") Integer userId) {
        return new SuccessRestResponse();
    }
}
