package com.groupa.ssi.controller.audit;

import com.groupa.ssi.common.response.rest.SuccessRestResponse;
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
public class AuditExternalDeleteController extends AuditExternalAbstractController {

    @ApiOperation(value = "Delete AuditExternal")
    @RequestMapping(value = "/{auditExternalId}", method = RequestMethod.DELETE)
    public SuccessRestResponse deleteAuditExternal(@PathVariable Integer auditExternalId, @RequestParam(value = "userId") Integer userId) {
        return new SuccessRestResponse();
    }
}
